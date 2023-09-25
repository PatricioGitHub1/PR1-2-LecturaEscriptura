import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PR122cat {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String basePath = System.getProperty("user.dir");
        System.out.println(basePath);
        System.out.print("Ruta de l'arxiu de text (tenir en compte que estas a ../FilesReadWrite :) ");
        String inputPath = sc.next();

        String total_path = basePath+inputPath;
        File arx = new File(total_path);

        if (!arx.exists()) {
            System.out.println("Aquest arxiu no existeix.");
        } else if (arx.isFile() && arx.canRead()) {
            readFile(total_path);
        } else if (arx.isDirectory()){
            System.out.println("S'ha introduit el path d'un directori");
        } else {
            System.out.println("No s'ha pogut accedir a aquest arxiu o no existeix");
        }

        System.out.println("\nPath usado = "+total_path);
    }

    static void readFile(String path) {
        int lineNumber = 1;
        File text = new File(path);
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
