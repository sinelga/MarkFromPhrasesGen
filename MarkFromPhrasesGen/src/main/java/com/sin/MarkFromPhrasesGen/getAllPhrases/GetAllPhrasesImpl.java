package com.sin.MarkFromPhrasesGen.getAllPhrases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetAllPhrasesImpl implements GetAllPhrases{

	private String sqlstr;
	private List<String> phrasesarr;

	public List<String> getAll(Connection con,String tablename) throws SQLException {
		// TODO Auto-generated method stub
		Statement stat = con.createStatement();
		sqlstr = "select Keyword from "+tablename+";";
		ResultSet rs = stat.executeQuery(sqlstr);
		
		phrasesarr = new ArrayList<String>();
		while (rs.next()) {

			String phrase = rs.getString("Keyword");
			
//			System.out.println( phrase );
			phrasesarr.add(phrase);
		}
		
		
		return phrasesarr;
	}

}
