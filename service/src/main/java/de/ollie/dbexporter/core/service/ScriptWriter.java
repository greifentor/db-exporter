package de.ollie.dbexporter.core.service;

import java.io.IOException;

import de.ollie.dbexporter.core.model.ScriptModel;
import de.ollie.dbexporter.core.model.DBExporterConfiguration;

public interface ScriptWriter {

	public static final String COLUMN_NAME_PLACE_HOLDER = "${ColumnName}";
	public static final String TABLE_NAME_PLACE_HOLDER = "${TableName}";

	void createScript(ScriptModel scriptModel, DBExporterConfiguration configuration) throws IOException;

}
