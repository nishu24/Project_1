package com.ers.utils;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnector {
    Connection getConnection(String username, String password, String url) throws SQLException;
    Connection getConnection() throws SQLException;
}
