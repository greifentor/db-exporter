package de.ollie.dbexporter.core.service.impl;

import java.io.IOException;

import javax.inject.Named;

import de.ollie.dbexporter.core.model.DBExporterConfiguration;
import de.ollie.dbexporter.core.model.OperationModel;
import de.ollie.dbexporter.core.model.ScriptModel;
import de.ollie.dbexporter.core.service.ScriptWriter;

@Named
public class ScriptWriterImpl implements ScriptWriter {

	@Override
	public void createScript(ScriptModel scriptModel, DBExporterConfiguration configuration) throws IOException {
		for (OperationModel operation : scriptModel.getOperations()) {
			writeOperation(operation, configuration);
		}
	}

	private void writeOperation(OperationModel operation, DBExporterConfiguration configuration) throws IOException {
		// TODO
	}

}