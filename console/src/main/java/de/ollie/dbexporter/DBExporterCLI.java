package de.ollie.dbexporter;

import javax.inject.Inject;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import de.ollie.dbexporter.core.converter.DataModelToDBExporterModelConverter;
import de.ollie.dbexporter.core.service.ScriptWriter;
import de.ollie.dbexporter.core.service.DBExporterScriptGenerator;

@SpringBootApplication
@ComponentScan("de.ollie")
public class DBExporterCLI implements ApplicationRunner {

	@Inject
	private DataModelToDBExporterModelConverter dataModelToTableCleanerModelConverter;
	@Inject
	private DBExporterScriptGenerator tableCleanerScriptGenerator;
	@Inject
	private ScriptWriter scriptWriter;

	public static void main(String[] args) {
		SpringApplication.run(DBExporterCLI.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		new ConsoleRunner(dataModelToTableCleanerModelConverter, System.out, tableCleanerScriptGenerator, scriptWriter)
				.run(args);
	}

}