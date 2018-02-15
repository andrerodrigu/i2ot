package project.util;

import java.util.ArrayList;
import java.util.List;

public class NameHandler {
    private static String name;

    public NameHandler() {
        name = null;
    }
    
    public static List<String> getCuttedCodes(){
        List<String> strList = new ArrayList<>();
        char[] dst = new char[24];
        int strSize = name.length();
        int i = 23, inicio = 0;
        
        while(i < strSize){
            name.getChars(inicio, i+1, dst, 0);
            strList.add(String.valueOf(dst));
            
            inicio = i+1;
            i += 24;
        }
        
        return strList;
        
    }
    
    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
