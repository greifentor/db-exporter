package de.ollie.dbexporter.core.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import archimedes.legacy.scheme.ArchimedesObjectFactory;
import archimedes.model.DataModel;
import archimedes.scheme.xml.ModelXMLReader;
import de.ollie.dbexporter.core.model.DBExporterModel;
import de.ollie.dbexporter.core.model.ReferenceColumnInfo;

@ExtendWith(MockitoExtension.class)
class DataModelToDBExporterModelConverterTest {

	private DataModel dataModel;

	@InjectMocks
	private DataModelToDBExporterModelConverter unitUnderTest;

	@BeforeEach
	void setUp() {
		ModelXMLReader reader = new ModelXMLReader(new ArchimedesObjectFactory());
		dataModel = reader.read("src/test/resources/models/Converter-Test.xml");
	}

	int getIgnoredTableCount(DataModel dataModel) {
		return (int) List
				.of(dataModel.getTables())
				.stream()
				.filter(table -> table.isOptionSet(DataModelToDBExporterModelConverter.DB_EXPORTER_IGNORE))
				.count();
	}

	@Nested
	class TestsOfMethod_convert_DataModel {

		private DBExporterModel dbExporterModel;

		@Nested
		class cleanRun {

			@BeforeEach
			void setUp() {
				dbExporterModel = unitUnderTest.convert(dataModel);
			}

			@Test
			void hasTheSameTableCountThanTheDataModel() {
				assertEquals(
						dataModel.getTables().length - getIgnoredTableCount(dataModel),
						dbExporterModel.getTableInfoCount());
			}

			@ParameterizedTest
			@ValueSource(strings = { "A_TABLE", "TABLE_NULLABLE_REF", "TABLE_NOT_NULLABLE_REF" })
			void hasTheAllNotIgnoredTablesInTheModel(String tableName) {
				assertEquals(tableName, dbExporterModel.getTableInfoByName(tableName).getName());
			}

			@Test
			void TableTABLE_NULLABLE_REFCorrectReferenceColumnInfoCount() {
				assertEquals(
						1,
						dbExporterModel.getTableInfoByName("TABLE_NULLABLE_REF").getReferenceColumnInfos().size());
			}

			@Test
			void TableTABLE_NULLABLE_REFCorrectReferenceColumnInfoSet() {
				assertEquals(
						new ReferenceColumnInfo()
								.setName("NULLABLE_REF")
								.setNullable(true)
								.setReferencedTableName("A_TABLE"),
						dbExporterModel.getTableInfoByName("TABLE_NULLABLE_REF").getReferenceColumnInfos().get(0));
			}

			@Test
			void TableTABLE_NOT_NULLABLE_REFCorrectReferenceColumnInfoCount() {
				assertEquals(
						1,
						dbExporterModel.getTableInfoByName("TABLE_NOT_NULLABLE_REF").getReferenceColumnInfos().size());
			}

			@Test
			void TableTABLE_NOT_NULLABLE_REFCorrectReferenceColumnInfoSet() {
				assertEquals(
						new ReferenceColumnInfo()
								.setName("NOT_NULLABLE_REF")
								.setNullable(false)
								.setReferencedTableName("A_TABLE"),
						dbExporterModel.getTableInfoByName("TABLE_NOT_NULLABLE_REF").getReferenceColumnInfos().get(0));
			}

		}

	}

}