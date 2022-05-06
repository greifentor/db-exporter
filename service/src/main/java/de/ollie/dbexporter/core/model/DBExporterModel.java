package de.ollie.dbexporter.core.model;

import java.util.HashMap;
import java.util.Map;

import lombok.ToString;

@ToString
public class DBExporterModel {

	private Map<String, TableInfo> tableInfos = new HashMap<>();

	public DBExporterModel addTableInfo(TableInfo... tableInfos) {
		for (TableInfo tableInfo : tableInfos) {
			this.tableInfos.put(tableInfo.getName(), tableInfo);
		}
		return this;
	}

	public TableInfo getTableInfoByName(String tableName) {
		return tableInfos.get(tableName);
	}

	public int getTableInfoCount() {
		return tableInfos.size();
	}

}