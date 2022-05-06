package de.ollie.dbexporter.core.service;

import de.ollie.dbexporter.core.model.DBExporterModel;
import de.ollie.dbexporter.core.model.ScriptModel;

public interface DBExporterScriptGenerator {

	ScriptModel generateExportScriptFor(DBExporterModel dbExporterModel);

}