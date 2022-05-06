package de.ollie.dbexporter.commands.createcleanscript;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import archimedes.legacy.scheme.ArchimedesObjectFactory;
import archimedes.model.DataModel;
import archimedes.scheme.xml.ModelXMLReader;
import de.ollie.dbexporter.core.converter.DataModelToDBExporterModelConverter;
import de.ollie.dbexporter.core.model.DBExporterConfiguration;
import de.ollie.dbexporter.core.service.impl.ScriptWriterImpl;
import de.ollie.dbexporter.core.service.impl.DBExporterScriptGeneratorImpl;

@ExtendWith(MockitoExtension.class)
class CleanScriptCreateCommandTest {

	@Test
	void cleanRun() throws Exception {
		// Prepare
		ModelXMLReader reader = new ModelXMLReader(new ArchimedesObjectFactory());
		DataModel dataModel = reader.read("src/test/resources/models/Integration-Test.xml");
		OutputStream out = new ByteArrayOutputStream();
		// Run
		new CleanScriptCreateCommand(
				new DBExporterConfiguration()
						.setDataModel(dataModel)
						.setOutputStream(out),
				new DataModelToDBExporterModelConverter(),
				new DBExporterScriptGeneratorImpl(),
				new ScriptWriterImpl()).createScript();
		// Check
		assertEquals("TODO", out.toString());
	}

}