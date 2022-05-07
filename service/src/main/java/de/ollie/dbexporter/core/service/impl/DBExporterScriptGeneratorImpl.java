package de.ollie.dbexporter.core.service.impl;

import javax.inject.Named;

import de.ollie.dbexporter.core.model.DBExporterModel;
import de.ollie.dbexporter.core.model.ScriptModel;
import de.ollie.dbexporter.core.service.DBExporterScriptGenerator;

@Named
public class DBExporterScriptGeneratorImpl implements DBExporterScriptGenerator {

	@Override
	public ScriptModel generateExportScriptFor(DBExporterModel dbExporterModel) {
		return null;
	}

}