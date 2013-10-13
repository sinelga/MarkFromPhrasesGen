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
       if (args.length == 2) {
		
        locale = args[0];
        themes = args[1];
        
        System.out.println(args[0]+" "+args[1]);
               
		injector = Guice.createInjector(new GuiceModule());
		guiceModuleManager = injector.getInstance(GuiceModuleManager.class);

		con = guiceModuleManager.sqlInit("/home/juno/git/goFastCgi/goFastCgi/singo.db");
		
		allPhrases = guiceModuleManager.allPhrases(con,locale,themes);
		
		guiceModuleManager.doMarkFiles(allPhrases, locale, themes);
		guiceModuleManager.doKeywords(con, allPhrases, locale, themes);
		con.close();
		
       }
		
		
    }
}
