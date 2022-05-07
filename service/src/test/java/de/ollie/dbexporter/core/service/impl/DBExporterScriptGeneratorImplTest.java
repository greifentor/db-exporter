package de.ollie.dbexporter.core.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import de.ollie.dbexporter.core.model.DBExporterModel;
import de.ollie.dbexporter.core.model.ReferenceColumnInfo;
import de.ollie.dbexporter.core.model.ScriptModel;
import de.ollie.dbexporter.core.model.TableInfo;

@ExtendWith(MockitoExtension.class)
class DBExporterScriptGeneratorImplTest {

	private static final String A_TABLE_NAME = "ATable";
	private static final String B_TABLE_NAME = "BTable";
	private static final String REF_TO_A_COLUMN_NAME = "RefToAColumn";

	@InjectMocks
	private DBExporterScriptGeneratorImpl unitUnderTest;

	@Nested
	class TestsOfMethod_generateExportScriptFor_DBExporterModel {

		@Test
		void returnsACorrectScriptModel() {
			// Prepare
			DBExporterModel dbExporterModel =
					new DBExporterModel()
							.addTableInfo(
									new TableInfo()
											.addReferenceColumnInfo(
													new ReferenceColumnInfo()
															.setName(REF_TO_A_COLUMN_NAME)
															.setReferencedTableName(A_TABLE_NAME))
											.setName(B_TABLE_NAME),
									new TableInfo().setName(A_TABLE_NAME));
			// Run
			ScriptModel returned = unitUnderTest.generateExportScriptFor(dbExporterModel);
			// Check
			assertEquals(2, returned.getOperations().size());
		}

	}

}