import java.io.*;
import java.util.*;
class Question4
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=10; i++){
            list.add(i);
        }

        list.stream().forEach(i -> {
            if(i<=5)return; //Using return as an alternative for continue
            System.out.println(i);
        });
    }
}