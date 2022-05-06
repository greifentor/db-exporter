package de.ollie.dbexporter.core.model;

import lombok.Data;
import lombok.Generated;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Generated
public class ReferenceColumnInfo {

	private String name;
	private boolean nullable;
	private String referencedTableName;

}