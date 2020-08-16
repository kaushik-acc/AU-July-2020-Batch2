import java.io.*;
import java.util.*;
class Question2
{
    
    public static void main(String args[]) {   
     
     TreeMap <Character,Integer> map = new TreeMap <> ();   
     
     map.put('A', 1);
     map.put('B', 2);
     map.put('C', 3);
     map.put('D', 4);
   
     System.out.println("Reverse order view of the keys: " + map.descendingKeySet());
    }
   
}