import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PR124linies {
    public static void main(String[] args){
        // Comprovar si el fitxer existeix i sino crear-lo
        String basePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "numeros.txt";
        File fline = new File(basePath);
        if (!fline.exists()) {
            try {
                fline.createNewFile();
                System.out.println("The file numeros.txt was created");
            } catch (IOException e) {
                System.out.println("Error while creating file numeros.txt");
            }
            
        } else {
            System.out.println("The file numeros.txt already exists");
        }

        try {
            FileWriter fw = new FileWriter(basePath);
            for (int i = 0; i != 10; i++) {
                int numero_random = (int) (Math.random() * 1000);
                fw.write(numero_random+"\n");
            }
            fw.close();
            System.out.println("The file was closed");
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    }
}
