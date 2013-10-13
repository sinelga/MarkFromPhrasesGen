package com.sin.MarkFromPhrasesGen.doMarkFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import com.sin.MarkFromPhrasesGen.ComUtils.Capitalizer;

public class DoMarkFileImpl implements DoMarkFile{
	private static List<String> constractedPhrases;
	
	private static String newline = System.getProperty("line.separator");
	
	public void doFile(List<String> phrasesarr,String locale, String themes) throws IOException {
		
		System.out.println("1 size "+phrasesarr.size());
		
		HashSet<String> hs = new HashSet<String>();
		hs.addAll(phrasesarr);
		phrasesarr.clear();
		phrasesarr.addAll(hs);
		
		System.out.println("2 size "+phrasesarr.size());
		
		long seed = System.nanoTime();
		Collections.shuffle(phrasesarr, new Random(seed));
		
		String buffline = "";
		constractedPhrases = new ArrayList<String>();
		
		for (String str:phrasesarr) {
			
//			System.out.println( str );
			
			if (buffline.length() < 70) {
				
				buffline = buffline + " " + str;
				
			}
			if (buffline.length() >= 70) {

				if (buffline.startsWith(" ")) {
					buffline = buffline.substring(1);
				}
				
				buffline = Capitalizer.capitalize(buffline);
				constractedPhrases.add(buffline + ".");
				buffline = "";
			}
					
		}
		
		String filestr ="all_"+locale+"_"+themes+".txt";
		
		FileWriter writer = new FileWriter(filestr);
		
		for (String res:constractedPhrases){
			 writer.write(res);
			 writer.write(newline);
			
		}
		
		writer.close();
			
	}

}
