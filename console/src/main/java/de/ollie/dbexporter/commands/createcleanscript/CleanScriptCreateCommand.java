package de.ollie.dbexporter.commands.createcleanscript;

import de.ollie.dbexporter.core.converter.DataModelToDBExporterModelConverter;
import de.ollie.dbexporter.core.model.ScriptModel;
import de.ollie.dbexporter.core.model.DBExporterConfiguration;
import de.ollie.dbexporter.core.model.DBExporterModel;
import de.ollie.dbexporter.core.service.ScriptWriter;
import de.ollie.dbexporter.core.service.DBExporterScriptGenerator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CleanScriptCreateCommand {

	private final DBExporterConfiguration tableCleanerConfiguration;
	private final DataModelToDBExporterModelConverter dataModelToTableCleanerModelConverter;
	private final DBExporterScriptGenerator tableCleanerScriptGenerator;
	private final ScriptWriter scriptWriter;

	private ScriptModel scriptModel;
	private DBExporterModel tableCleanerModel;

	public synchronized void createScript() throws Exception {
		convertDataModelToTableCleanerModel();
		generateCleanScriptForTableCleanerModel();
		writeScript();
	}

	private void convertDataModelToTableCleanerModel() {
		tableCleanerModel = dataModelToTableCleanerModelConverter.convert(tableCleanerConfiguration.getDataModel());
	}

	private void generateCleanScriptForTableCleanerModel() {
		scriptModel = tableCleanerScriptGenerator.generateExportScriptFor(tableCleanerModel);
	}

	private void writeScript() throws Exception {
		scriptWriter.createScript(scriptModel, tableCleanerConfiguration);
	}

}