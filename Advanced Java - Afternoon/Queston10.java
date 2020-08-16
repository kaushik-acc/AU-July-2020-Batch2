import java.io.*;
import java.util.*;


class Question10
{
    public static void main(String[] args) throws IOException
    {
        File from = new File("MyInputFile.txt");
        File to = new File("C:\\Users\\Kaushik\\Desktop\\CP\\copiedFile.txt");
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(from);
            os = new FileOutputStream(to);

            // buffer size 1K
            byte[] buf = new byte[1024];

            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
            }
        } 
        catch(IOException ioe){
    		ioe.printStackTrace();
         }
         finally {
            is.close();
            os.close();
        }
    }
}