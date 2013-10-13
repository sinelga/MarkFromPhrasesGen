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
	private String tablename;

	public List<String> getAll(Connection con,String locale,String themes) throws SQLException {
		// TODO Auto-generated method stub
		tablename = locale+"_"+themes+"_phrases";
		
		Statement stat = con.createStatement();
		sqlstr = "select Keyword from "+tablename+";";
		ResultSet rs = stat.executeQuery(sqlstr);
		
		phrasesarr = new ArrayList<String>();
		while (rs.next()) {

			String phrase = rs.getString("Keyword");

			phrasesarr.add(phrase);
		}
		
		
		return phrasesarr;
	}

}
