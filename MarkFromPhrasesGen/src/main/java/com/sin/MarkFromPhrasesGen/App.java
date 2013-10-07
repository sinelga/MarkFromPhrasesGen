package com.sin.MarkFromPhrasesGen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Injector  injector;
	private static GuiceModuleManager guiceModuleManager;
	private static Connection con;
	private static List<String> allPhrases;
	private static String locale;
	private static String themes;

	public static void main( String[] args ) throws ClassNotFoundException, SQLException, IOException
    {
        System.out.println( "Hello World!" );
        locale = "it_IT";
        themes = "finance";
        
        
		injector = Guice.createInjector(new GuiceModule());
		guiceModuleManager = injector.getInstance(GuiceModuleManager.class);

		con = guiceModuleManager.sqlInit("/home/juno/git/goFastCgi/goFastCgi/singo.db");
		
		allPhrases = guiceModuleManager.allPhrases(con,"it_IT_finance_phrases");
		
		guiceModuleManager.doMarkFiles(allPhrases, locale, themes);
		
		
    }
}
