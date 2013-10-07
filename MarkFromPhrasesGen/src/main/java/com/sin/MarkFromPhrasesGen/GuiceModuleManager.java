package com.sin.MarkFromPhrasesGen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;

import com.google.inject.Inject;
import com.sin.MarkFromPhrasesGen.doMarkFile.DoMarkFile;
import com.sin.MarkFromPhrasesGen.getAllPhrases.GetAllPhrases;
import com.sin.MarkFromPhrasesGen.sqlinit.SqlInit;
//import com.sin.SearchGoogleLogParser.domains.RemoteKeyword;
//import com.sin.SearchGoogleLogParser.exportkeywords.ExportKeywords;
//import com.sin.SearchGoogleLogParser.parserlog.ParserLog;
//import com.sin.SearchGoogleLogParser.sqlbydaystat.Sqlbydaystat;
//import com.sin.SearchGoogleLogParser.sqlinit.SqlInit;
//import com.sin.SearchGoogleLogParser.sqlstat.SqlStat;


public class GuiceModuleManager {
	
	private static final Logger log = Logger.getLogger(GuiceModuleManager.class
			.getName());

//	private SqlStat sqlStat;
	private SqlInit sqlInit;
	private GetAllPhrases getAllPhrases;
	private DoMarkFile doMarkFile;
//	private ParserLog parserLog;
//	private Sqlbydaystat sqlbydaystat;
//	private ExportKeywords exportKeywords; 

//	private Connection con;

	private List<String> allPhrase;

	private Connection con;
	
	@Inject
	public void StartProvider(SqlInit sqlInit,GetAllPhrases getAllPhrases,DoMarkFile doMarkFile){
		
//		this.sqlStat = sqlStat;
		this.sqlInit = sqlInit;
		this.getAllPhrases = getAllPhrases;
		this.doMarkFile = doMarkFile;
//		this.parserLog = parserLog;
//		this.sqlbydaystat = sqlbydaystat;
//		this.exportKeywords = exportKeywords;
	}
	
	
//	public void exportkeywords(List<RemoteKeyword> remoteKeywords) throws IOException {
//		
//		exportKeywords.export(remoteKeywords);
//		
//	}
//		
//	public String[] parserLog(String logstr){
//		
//		return parserLog.parseStr(logstr);
//		
//	}e
//	
	
	public List<String> allPhrases(Connection con,String tablename) throws SQLException{
		
		allPhrase =getAllPhrases.getAll(con, tablename);
		return allPhrase;
		
	}
	
	public Connection sqlInit(String sqliteDb) throws ClassNotFoundException, SQLException{
		
		con = sqlInit.init(sqliteDb);
		
		return con;
	}
	
	public void doMarkFiles(List<String> phrasesarr,String locale,String themes) throws IOException {
		
		doMarkFile.doFile(phrasesarr, locale, themes);
		
	}
	
//	
//	public void insertRecord(Connection con,String[] record ) throws ClassNotFoundException, SQLException, ParseException{
//		
//		sqlStat.insertRecord(con,record);
//	}	
//	
//	public void insertBydayRecord(Connection con,String[] record ) throws ClassNotFoundException, SQLException, ParseException{
//			
//		sqlbydaystat.insert(con, record);
//	}
//	
	
}
