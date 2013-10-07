package com.sin.MarkFromPhrasesGen.sqlinit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlInitImpl implements SqlInit{

	private Connection con;
	private String constr;

	public Connection init(String sqliteDb) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Class.forName("org.sqlite.JDBC");
		constr = "jdbc:sqlite:"+sqliteDb;
		this.con = DriverManager.getConnection(constr );
		
		return con;
	}

}
