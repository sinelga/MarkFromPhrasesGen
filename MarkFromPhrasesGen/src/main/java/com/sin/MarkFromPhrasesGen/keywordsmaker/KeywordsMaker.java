package com.sin.MarkFromPhrasesGen.keywordsmaker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface KeywordsMaker {

	void Makekeywords(Connection con,List<String> phrase,String locale,String themes) throws SQLException;
}
