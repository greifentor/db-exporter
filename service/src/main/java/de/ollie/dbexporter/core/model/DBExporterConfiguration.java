package de.ollie.dbexporter.core.model;

import java.io.OutputStream;

import archimedes.model.DataModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class DBExporterConfiguration {

	private DataModel dataModel;
	private OutputStream outputStream;

}