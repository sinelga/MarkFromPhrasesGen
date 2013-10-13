package com.sin.MarkFromPhrasesGen.keywordsDB;

import java.sql.Connection;
import java.sql.SQLException;

public interface KeywordsDB {
	
	void checkIfExist(Connection con,String keyword,String locale,String themes) throws SQLException;

}
