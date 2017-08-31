package com.kavzor.tools.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler extends TextHandler{

	public FileHandler(File textFile, String section) {
		super(textFile, section);
	}

	private ArrayList<String> list;
	
    public ArrayList<String> getList(){
    	return list;
    }

    
    public ArrayList<String> toList(File textFile, String section){
    	list = new ArrayList<>();
    	Scanner scanner = null;
        try {
            scanner = new Scanner(textFile);
            String line = scanner.nextLine();
            boolean EOL = false;
            while(!EOL && line != null){


                if(line.contains(SECTION_SEPERATOR) && line.contains(section)){

                    line = scanner.nextLine();
                    while(!line.contains(SECTION_SEPERATOR) && !EOL){
                        list.add(line);
                        if(!scanner.hasNext()){
                            EOL = true;
                        }
                        else {
                            line = scanner.nextLine();
                        }
                    }
                }

                if(!scanner.hasNext()){
                    EOL = true;
                }
                else {
                    line = scanner.nextLine();
                }
            }

        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
        	scanner.close();
        }
        
        return list;
    }
    
	public String getRandom() {
		list.remove("");
		int randomItem = (int) (Math.random() * list.size());
		return list.get(randomItem);
	}
}
