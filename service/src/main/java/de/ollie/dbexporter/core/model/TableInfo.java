package de.ollie.dbexporter.core.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class TableInfo {

	private String name;
	@Setter(AccessLevel.PRIVATE)
	private List<ReferenceColumnInfo> referenceColumnInfos = new ArrayList<>();

	public TableInfo addReferenceColumnInfo(ReferenceColumnInfo... columnInfos) {
		for (ReferenceColumnInfo columnInfo : columnInfos) {
			referenceColumnInfos.add(columnInfo);
		}
		return this;
	}

}