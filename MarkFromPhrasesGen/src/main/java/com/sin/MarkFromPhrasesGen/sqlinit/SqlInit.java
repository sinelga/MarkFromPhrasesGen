package com.sin.MarkFromPhrasesGen.sqlinit;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqlInit {
	Connection init(String sqliteDb) throws SQLException, ClassNotFoundException;
}
