package de.ollie.dbexporter.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DBExporterModelTest {

	private static final String TABLE_NAME = "tableName";

	@Mock
	private TableInfo tableInfo;

	@InjectMocks
	private DBExporterModel unitUnderTest;

	void trainTableInfoMock() {
		when(tableInfo.getName()).thenReturn(TABLE_NAME);
	}

	@Nested
	class TestsOfMethod_addTableInfo_TableInfo {

		@BeforeEach
		void setUp() {
			trainTableInfoMock();
		}

		@Test
		void passATableInfo_hasATableInfoInTheDBExportModel() {
			assertEquals(1, unitUnderTest.addTableInfo(tableInfo).getTableInfoCount());
		}

		@Test
		void passATableInfo_hasTheCorrectTableInfoInTheDBExportModel() {
			assertEquals(
					TABLE_NAME,
					unitUnderTest.addTableInfo(tableInfo).getTableInfoByName(tableInfo.getName()).getName());
		}

	}

}