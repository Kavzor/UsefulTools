package com.kavzor.tools.file;

import java.io.File;
import java.util.ArrayList;

public interface FileConvertor {
	ArrayList<String> toList(File file, String section);
}
