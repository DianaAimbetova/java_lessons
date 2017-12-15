import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class FileTest {

    public static void main(String[] args) {
        File f = new File("new.txt");
        File f1 = new File("ok.txt");
        File f3 = new File("C:\\Users\\Diana_Aimbetova\\IdeaProjects\\java_lessons");
        PrintWriter wfile =null;
        FileReader fr = null;
        PrintWriter fr2 = null;
        BufferedReader br = null;
        try {
           File[] files = f3.listFiles();
           for(File f2:files){
               if(!f2.isDirectory()){
                   System.out.println(f2.getCanonicalPath());
               }
           }
             wfile = new PrintWriter(f);
             fr = new FileReader(f);
            fr2 = new PrintWriter(f1);
             br = new BufferedReader(fr);
            wfile.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            wfile.close();
            String line;
            while((line=br.readLine())!=null){
               System.out.print(line);
                fr2.print(line);

            }

            String s = FileUtils.readFileToString(f,"UTF-8");
            IOUtils.copy(fr,wfile);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(wfile!=null){
            wfile.close();}
            if(fr2!=null){
                fr2.close();}
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
    }
}
