import java.io.*;
import java.util.*;
class Question8
{
    public static void main(String[] args) throws IOException
    {
        String folderName="C:\\Users\\Kaushik\\Desktop\\CP"; 
        File folder =new File(folderName);
        File[] txtfiles=folder.listFiles(new FilenameFilter() { 
            public boolean accept(File dir, String filename)
                 { return filename.endsWith(".txt"); }});
        for(File file:txtfiles)
        {
            if(file.delete())
                System.out.println("Deleted the file: " + file.getName());
            else 
                System.out.println("Failed to delete the file.");
        
        }
    }
}