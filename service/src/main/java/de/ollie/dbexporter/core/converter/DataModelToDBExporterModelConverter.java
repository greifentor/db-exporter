package de.ollie.dbexporter.core.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Named;

import archimedes.model.ColumnModel;
import archimedes.model.DataModel;
import archimedes.model.TableModel;
import de.ollie.dbexporter.core.model.DBExporterModel;
import de.ollie.dbexporter.core.model.ReferenceColumnInfo;
import de.ollie.dbexporter.core.model.TableInfo;

@Named
public class DataModelToDBExporterModelConverter {

	public static final String DB_EXPORTER_IGNORE = "DB_EXPORTER_IGNORE";

	public DBExporterModel convert(DataModel dataModel) {
		DBExporterModel dbExporterModel = new DBExporterModel();
		streamOfAllNotIgnoredTables(dataModel)
				.forEach(
						table -> dbExporterModel
								.addTableInfo(
										new TableInfo()
												.addReferenceColumnInfo(getReferenceColumnInfo(table))
												.setName(table.getName())));
		return dbExporterModel;
	}

	private Stream<TableModel> streamOfAllNotIgnoredTables(DataModel dataModel) {
		return List
				.of(dataModel.getTables())
				.stream()
				.filter(table -> !table.isOptionSet(DB_EXPORTER_IGNORE));
	}

	private ReferenceColumnInfo[] getReferenceColumnInfo(TableModel table) {
		return List
				.of(table.getColumns())
				.stream()
				.filter(column -> isAReference(column) && !isToIgnore(column))
				.map(this::getColumnInfo)
				.collect(Collectors.toList())
				.toArray(new ReferenceColumnInfo[0]);
	}

	private boolean isAReference(ColumnModel column) {
		return column.getReferencedTable() != null;
	}

	private ReferenceColumnInfo getColumnInfo(ColumnModel column) {
		return new ReferenceColumnInfo()
				.setName(column.getName())
				.setNullable(!column.isNotNull())
				.setReferencedTableName(column.getReferencedTable().getName());
	}

	private boolean isToIgnore(ColumnModel column) {
		return column.getReferencedTable().isOptionSet(DB_EXPORTER_IGNORE);
	}

}