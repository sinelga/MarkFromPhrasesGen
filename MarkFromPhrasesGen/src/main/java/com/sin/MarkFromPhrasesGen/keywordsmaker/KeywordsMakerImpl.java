package com.sin.MarkFromPhrasesGen.keywordsmaker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.google.inject.Inject;
import com.sin.MarkFromPhrasesGen.keywordsDB.KeywordsDB;

public class KeywordsMakerImpl implements KeywordsMaker {

	private KeywordsDB keywordsDB;

	@Inject
	public KeywordsMakerImpl(KeywordsDB keywordsDB) {

		this.keywordsDB = keywordsDB;

	}

	public void Makekeywords(Connection con, List<String> phrasesarr,
			String locale, String themes) throws SQLException {
		// TODO Auto-generated method stub
		for (String phrase : phrasesarr) {

			String split_keywords[] = phrase.split(" ");

			if (split_keywords.length > 0) {

				List<String> keywordArr = new ArrayList<String>();

				for (String keyword : split_keywords) {

					if (keyword.matches("[a-zA-Z]*") && keyword.length() > 2) {

						keywordArr.add(keyword.toLowerCase());

					}

				}

				HashSet<String> hs = new HashSet<String>();
				hs.addAll(keywordArr);
				keywordArr.clear();
				keywordArr.addAll(hs);

				for (String keyworduniq : keywordArr) {
					keywordsDB.checkIfExist(con, keyworduniq, locale, themes);

				}

			}

		}

	}

}
