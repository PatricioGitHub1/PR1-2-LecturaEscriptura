import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PR123append {
    public static void main(String[] args){
        String basePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "frasesMatrix.txt";
        String frase1 = "Yo sólo puedo mostrarte la puerta\n";
        String frase2 = "Tú eres quien la tiene que atravesar\n";
        
        //System.out.println(basePath);
        // Comprovar que el fichero exista
        File fm = new File(basePath);
        if (!fm.exists()) {
            try {
                fm.createNewFile();
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo matrix");
                e.printStackTrace();
            }
        }
        try {
            FileWriter fw = new FileWriter(basePath, true);
            fw.write(frase1);
            fw.write(frase2);
            fw.close();
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    }
}
