import java.io.*;
import java.util.*;
class Question3
{
    public static void main(String[] args) throws IOException
    {
        int count=1;
        try
        {
            while(count<=100)
            {
                if(isPrime(count))
                    throw new MyCustomException();
                count++;
            }
        }
        catch (MyCustomException e)
        {
            System.out.println("The count is prime");
        }
        
    }
    public static boolean isPrime(int n)
    {
        int f=0;
        for(int i=1;i<=n;i++)
            if(n%i==0)
                f++;
        if(f==2)
            return true;
        return false;
    }
}
class MyCustomException extends RuntimeException {


}