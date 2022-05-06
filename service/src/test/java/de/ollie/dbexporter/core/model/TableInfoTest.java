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
class TableInfoTest {

	private static final String COLUMN_NAME = "columnName";

	@Mock
	private ReferenceColumnInfo columnInfo;

	@InjectMocks
	private TableInfo unitUnderTest;

	void trainColumnInfoMock() {
		when(columnInfo.getName()).thenReturn(COLUMN_NAME);
	}

	@Nested
	class TestsOfMethod_addTableInfo_ColumnInfo {

		@BeforeEach
		void setUp() {
			trainColumnInfoMock();
		}

		@Test
		void passAColumnInfo_isStoredInTheTableInfo() {
			unitUnderTest.addReferenceColumnInfo(columnInfo);
			assertEquals(COLUMN_NAME, unitUnderTest.getReferenceColumnInfos().get(0).getName());
		}

	}

}