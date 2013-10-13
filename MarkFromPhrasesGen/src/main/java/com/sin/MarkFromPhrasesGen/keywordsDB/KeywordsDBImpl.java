package com.sin.MarkFromPhrasesGen.keywordsDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class KeywordsDBImpl implements KeywordsDB{
	
	private String sqlstr;
	private Date now;

	public void checkIfExist(Connection con, String keyword, String locale,
			String themes) throws SQLException {

		now = new Date();
		String tablename =locale+"_"+themes+"_keywords";
		
		Statement stat = con.createStatement();
		sqlstr = "select Keyword from "+tablename+" where Keyword='"+keyword+"';";
//		System.out.println(sqlstr);
		ResultSet rs = stat.executeQuery(sqlstr);
		
		boolean empty = true;
		
		while (rs.next()) {
			
			empty = false;			
		}
				
		if (empty) {
						
			System.out.println( keyword);
			PreparedStatement prep = con
					.prepareStatement("insert into "+tablename+"(Created,Locale,Themes,Keyword,Block,Hits) values(?,?,?,?,?,?);");
			
			prep.setLong(1, now.getTime());
			prep.setString(2, locale);
			prep.setString(3, themes);
			prep.setString(4, keyword);
			prep.setInt(5, 1);
			prep.setInt(6, 0);
			prep.execute();
									
		} 
					
	}

}
