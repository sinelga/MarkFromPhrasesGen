package com.sin.MarkFromPhrasesGen;


import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;
import com.sin.MarkFromPhrasesGen.doMarkFile.DoMarkFile;
import com.sin.MarkFromPhrasesGen.doMarkFile.DoMarkFileImpl;
import com.sin.MarkFromPhrasesGen.getAllPhrases.GetAllPhrases;
import com.sin.MarkFromPhrasesGen.getAllPhrases.GetAllPhrasesImpl;
import com.sin.MarkFromPhrasesGen.sqlinit.SqlInit;
//import com.sin.SearchGoogleLogParser.exportkeywords.ExportKeywords;
//import com.sin.SearchGoogleLogParser.exportkeywords.ExportKeywordsImpl;
//import com.sin.SearchGoogleLogParser.parserlog.ParserLog;
//import com.sin.SearchGoogleLogParser.parserlog.ParserLogImpl;
//import com.sin.SearchGoogleLogParser.sqlbydaystat.Sqlbydaystat;
//import com.sin.SearchGoogleLogParser.sqlbydaystat.SqlbydaystatImpl;
//import com.sin.SearchGoogleLogParser.sqlinit.SqlInit;
//import com.sin.SearchGoogleLogParser.sqlinit.SqlInitImpl;
//import com.sin.SearchGoogleLogParser.sqlstat.SqlStat;
//import com.sin.SearchGoogleLogParser.sqlstat.SqlStatImpl;
import com.sin.MarkFromPhrasesGen.sqlinit.SqlInitImpl;



public class GuiceModule implements Module{
		
	
	public void configure(Binder binder) {
		
		binder.bind(GetAllPhrases.class).to(GetAllPhrasesImpl.class).in(Scopes.SINGLETON);
		binder.bind(SqlInit.class).to(SqlInitImpl.class).in(Scopes.SINGLETON);
		
		binder.bind(DoMarkFile.class).to(DoMarkFileImpl.class).in(Scopes.SINGLETON);
//		binder.bind(Sqlbydaystat.class).to(SqlbydaystatImpl.class).in(Scopes.SINGLETON);
//		binder.bind(ExportKeywords.class).to(ExportKeywordsImpl.class).in(Scopes.SINGLETON);
//		binder.bind(HtmlParserProvider.class).to(HtmlParserProviderImpl.class).in(Scopes.SINGLETON);
//		binder.bind(TasksProvider.class).to(TasksProviderImpl.class).in(Scopes.SINGLETON);
//		binder.bind(InsertContImage.class).to(InsertContImageImpl.class).in(Scopes.SINGLETON);
//		binder.bind(CrawlerHandler.class).to(CrawlerHandlerImpl.class).in(Scopes.SINGLETON);
//		binder.bind(JsonToHtmlHandler.class).to(JsonToHtmlHandlerImpl.class).in(Scopes.SINGLETON);
//		binder.bind(RandMemcache.class).to(RandMemcacheImpl.class).in(Scopes.SINGLETON);
//		binder.bind(MakeKeywordJson.class).to(MakeKeywordJsonImpl.class).in(Scopes.SINGLETON);
//		binder.bind(CheckStopList.class).to(CheckStopListImpl.class).in(Scopes.SINGLETON);
//		binder.bind(MarkFile.class).to(MarkFileImpl.class);
//		binder.bind(CrListStopDomains.class).to(CrListStopDomainsImpl.class);
//		binder.bind(GetNewDomains.class).to(GetNewDomainsImpl.class);
//		binder.bind(UnlistedDomains.class).to(UnlistedDomainsImpl.class);
	}

}
