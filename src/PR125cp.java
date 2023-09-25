import java.io.File;

import java.util.Scanner;

public class PR125cp {
    public static void main(String[] args) {
        // Pedir direccciones
        String basePath = System.getProperty("user.dir");
        System.out.println("======\nEstas a: "+basePath+"\n======");
        Scanner sc = new Scanner(System.in);
        System.out.print("Path de origen: ");
        String original_path = sc.next();
        sc.nextLine();
        System.out.print("Path de destino: ");
        String final_path = sc.next();

        // Comprovar que exista fichero
        File f1 = new File(basePath+original_path);
        if (!f1.exists()) {
            System.out.println("El archivo no existe");
            System.out.println(f1.getAbsolutePath());
        } else {
            File f2 = new File(basePath+final_path);
            boolean wasMoved = f1.renameTo(f2);
            if (wasMoved) {
                System.out.println("El archivo se pudo mover");
            } else {
                System.out.println("El archivo NO se pudo mover");
            }
        }
        
    }
}
