package com.sin.MarkFromPhrasesGen.getAllPhrases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GetAllPhrases {

	List<String> getAll(Connection con,String locale,String themes) throws SQLException;
}
