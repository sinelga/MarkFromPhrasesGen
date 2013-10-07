package com.sin.MarkFromPhrasesGen.doMarkFile;

import java.io.IOException;
import java.util.List;

public interface DoMarkFile {
	
	void doFile(List<String> phrasesarr,String locale,String themes) throws IOException;

}
