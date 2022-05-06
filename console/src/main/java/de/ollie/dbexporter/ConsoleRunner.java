package de.ollie.dbexporter;

import java.io.PrintStream;

import org.springframework.boot.ApplicationArguments;

import archimedes.legacy.scheme.ArchimedesObjectFactory;
import archimedes.model.DataModel;
import archimedes.scheme.xml.ModelXMLReader;
import de.ollie.dbexporter.core.converter.DataModelToDBExporterModelConverter;
import de.ollie.dbexporter.core.service.DBExporterScriptGenerator;
import de.ollie.dbexporter.core.service.ScriptWriter;
import lombok.RequiredArgsConstructor;

/**
 * @author ollie (06.05.2022)
 */
@RequiredArgsConstructor
public class ConsoleRunner {

	private final DataModelToDBExporterModelConverter dataModelToDBExporterModelConverter;
	private final PrintStream out;
	private final DBExporterScriptGenerator dbExporterScriptGenerator;
	private final ScriptWriter scriptWriter;

	public void run(ApplicationArguments args) {
		try {
			// TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DataModel readDataModelFromFile(String fileName) {
		ModelXMLReader reader = new ModelXMLReader(new ArchimedesObjectFactory());
		return reader.read(fileName);
	}

}