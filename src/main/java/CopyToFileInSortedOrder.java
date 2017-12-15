import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CopyToFileInSortedOrder {

    public static void main(String[] args) {
        File initialFile = new File("ok.txt");
        File newFile = new File("new.txt");
        BufferedReader br = null;
        BufferedReader brNew = null;
        FileReader fr = null;
        PrintWriter pw = null;
        FileReader frNew = null;
        try{
            pw = new PrintWriter(newFile);
            fr = new FileReader(initialFile);
            br = new BufferedReader(fr);
            frNew = new FileReader(newFile);
            brNew = new BufferedReader(frNew);
            String line;
            List<String> list = new ArrayList<String>();
            System.out.println("------Given------");
            while((line=br.readLine())!=null){
                System.out.println(line);
                list.add(line);
            }
            Comparator<String> comparator = new Comparator<String>() {
                public int compare(String o1, String o2) {
                    if(o1.length() > o2.length()) {
                        return 1;
                    }else if(o1.length() < o2.length()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            };
            list.sort(comparator);
            System.out.println("--------Sorted--------");
            for (String s:list) {
                pw.println(s);
            }
            pw.close();
            fr.close();
            br.close();
            String fromNewFile;
            while((fromNewFile=brNew.readLine())!=null){
                System.out.println(fromNewFile);
            }

            frNew.close();
            brNew.close();
            if(newFile.length()!=0){
                System.out.println();
                System.out.println("Успешно записано!");
            }else {
                System.err.println("Не записалось!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
