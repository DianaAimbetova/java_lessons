import java.io.*;

public class InputOutputTest {
    public static void main(String[] args) throws IOException {

            FileReader rfile = new FileReader("ok.txt");
            BufferedReader br = new BufferedReader(rfile);
            PrintWriter wfile = new PrintWriter("new.txt");
        try {
            wfile.println("aaaaaaaaaaaaaa");
            wfile.close();
            int c;
            while((c=br.read())!=-1){
                System.out.println((char)c);
            }
        }catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }catch (IOException e){
            System.out.println("Ошибка еще");
        }finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
