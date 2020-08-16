import java.io.*;
import java.util.*;
class Question1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter the String");
        String s=br.readLine();
        System.out.println("Enter the regex pattern");
        String pat=br.readLine();
        System.out.println("Enter the replacement");
        String rep=br.readLine();
        String s1=s.replaceAll(pat, rep);
        System.out.println(s1);
        
    }
}