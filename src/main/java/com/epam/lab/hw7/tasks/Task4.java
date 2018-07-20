package com.epam.lab.hw7.tasks;

import com.epam.lab.hw7.JDBCConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class Task4 extends JDBCConnection {
    private static final Logger LOG = Logger.getLogger(Task4.class);
    private Connection connection = getConnection();

    void showData() {
        String[] types = {"TABLE"};
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            LOG.info(String.format("Database version: %s", metaData.getDatabaseProductVersion()));
            LOG.info(String.format("Driver name: %s", metaData.getDriverName()));
            LOG.info(String.format("Driver version: %s", metaData.getDriverVersion()));
            ResultSet table = metaData.getTables(null, null, "%", types);
            LOG.info("\nTables: ");
            ArrayList<String> tables = new ArrayList<>();
            while (table.next()) {
                LOG.info(table.getString(3));
                tables.add(table.getString(3));
            }
            LOG.info("\n");
            for (String actualTable : tables) {
                ResultSet rs = metaData.getColumns(null, null, actualTable, null);
                LOG.info(actualTable);
                while (rs.next()) {
                    LOG.info(rs.getString("COLUMN_NAME") + " " + rs.getString("TYPE_NAME") + " " + rs.getString("COLUMN_SIZE"));
                }
                LOG.info("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
