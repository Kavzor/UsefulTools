package com.kavzor.tools.file;

import java.io.File;

public abstract class TextHandler implements FileConvertor{

	protected static String SECTION_SEPERATOR = "###";
	
	public TextHandler(File textFile, String section) {
		toList(textFile, section);
	}
	
	public void setSeperator(String seperator) {
		SECTION_SEPERATOR = seperator;
	}
}
