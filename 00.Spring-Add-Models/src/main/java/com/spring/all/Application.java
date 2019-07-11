package com.spring.all;

import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author czg
 * @date 2019/7/11
 */
public class Application {
    public static void main(String args[]){
        System.out.println(System.getProperty("user.dir").toString());
        String path = System.getProperty("user.dir").toString();
        File file = new File(path);
        StringBuilder txt = new StringBuilder();
        if(file != null && file.isDirectory()){
            File files[] = file.listFiles();
            for(int x = 0;x<files.length;x++){
                if(files[x].isDirectory()){
                    String name = files[x].getName();
                    if(isNumber(name.substring(0,2))){
                        txt.append("<module>");
                        //String newStr = name.substring(name.indexOf(".")+1);
                        txt.append(name);
                        txt.append("</module>");
                        txt.append("\r\n");
                    }
                }
            }
        }
        try {
            saveFile(txt.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static boolean isNumber(String number){
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher isNum = pattern.matcher(number);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static void saveFile(String txt) throws Exception {
        String path = Application.class.getResource("/").getPath();
        File file = new File(path+File.separator+"models.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(txt.getBytes());

    }
}
