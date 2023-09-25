import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PR120ReadFile {
    public static void main(String[] args){
        String basePath = System.getProperty("user.dir") + File.separator+"src"+ File.separator;
        String filename = "PR120ReadFile.java";
        int lineNumber = 1;
        
        File text = new File(basePath+filename);
        System.out.println(basePath+filename);
        Scanner scnr;
        try {
            scnr = new Scanner(text);
            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                System.out.println("line " + lineNumber + " :" + line);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
