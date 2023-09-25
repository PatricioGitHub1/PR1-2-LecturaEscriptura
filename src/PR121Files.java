import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PR121Files {
    public static void main(String[] args){
        String basePath = System.getProperty("user.dir") + "/myFiles/";

        // Creem la carpeta myFiles si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'myFiles'");
            } else {
                System.out.println("S'ha creat el directori 'myFiles'");
            }
            
        } else {
            System.out.println("Ja existeix el directori 'myFiles'");
        }

        // Creem els arxius file1.txt i file2.txt
        ArrayList <File> listaFiles = new ArrayList<>();
        listaFiles.add(new File(basePath + "file1.txt"));
        listaFiles.add(new File(basePath + "file2.txt"));
        
        try {
            boolean fileCreated;
            for (File f: listaFiles) {
                fileCreated = f.createNewFile();
                
                if (fileCreated) {
                    System.out.println("S'ha creat l'arxiu \"" + f.getName() + "\"");
                } else {
                    System.out.println("No s'ha pogut crear l'arxiu \"" + f.getName() + "\"");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        // Renombrament de file2.txt a renamedFile.txt
        // File original
        File f2 = listaFiles.get(1);
        
        // File que es vol crear
        File f_renamed = new File(basePath + "renamedFile.txt");
        
        boolean wasRenamed = f2.renameTo(f_renamed);

        if (wasRenamed) {
            System.out.println("S'ha canviat el nom de l'arxiu a \"" + f_renamed.getName() + "\"");
        } else {
            System.out.println("No s'ha pogut canviar el nom de l'arxiu \"" + f_renamed.getName() + "\"");
        }

        // Mostrar el arxius dins el directori
        // Crida a funcio
        showFoldeFiles(basePath);

        // Eliminar file1.txt
        File f_del = listaFiles.get(0);
        if (f_del.delete()) {
            System.out.println("The file "+f_del.getName()+" was deleted");
        } else {
            System.out.println("The file "+f_del.getName()+" was NOT deleted");
        }

        // Mostrar el arxius dins el directori
        // Crida a funcio
        showFoldeFiles(basePath);
    }

    static void showFoldeFiles(String folderPath) {
        File folder = new File(folderPath);
        File[] archivos = folder.listFiles();
        System.out.println("El arxius de la carpeta son: ");
        for (File file : archivos) {
            System.out.println(" - "+file.getName());
        }
    }
}
