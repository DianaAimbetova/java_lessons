import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class NameFileRandomizer {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\Diana_Aimbetova\\Documents\\my folder");
        if(directory.exists()){
            File files[] = directory.listFiles();
            for(File f:files){
                if(!f.isDirectory()){
                    try {
                        Random random = new Random();
                        int names = random.nextInt(files.length+1);
                        FileUtils.copyFile(f,new File("C:\\Users\\Diana_Aimbetova\\Documents\\copy folder\\" +names+".png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
