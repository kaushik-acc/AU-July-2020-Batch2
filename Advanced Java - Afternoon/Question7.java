import java.io.*;
import java.util.*;
class Question7
{        
      public static void main(String[] args) throws IOException
    { 
        // Provide full path for directory(change accordingly)   
        String maindirpath = "C:\\Users\\Kaushik\\Desktop\\CP"; 
                  
        // File object 
        File maindir = new File(maindirpath); 
           
        if(maindir.exists() && maindir.isDirectory()) 
        { 
            // array for files and sub-directories  
            // of directory pointed by maindir 
            File arr[] = maindir.listFiles(); 
              
            listAllFiles(arr,0,0);  
       }  
    } 
 

    
    static void listAllFiles(File[] arr,int index,int level)  
     { 
         // terminate condition 
         if(index == arr.length) 
             return; 
           
         // tabs for internal levels 
         for (int i = 0; i < level; i++) 
             System.out.print("\t"); 
           
         // for files 
         if(arr[index].isFile()) 
             System.out.println(arr[index].getName()); 
           
         // for sub-directories 
         else if(arr[index].isDirectory()) 
         { 
             System.out.println("[" + arr[index].getName() + "]"); 
               
             // recursion for sub-directories 
             listAllFiles(arr[index].listFiles(), 0, level + 1); 
         } 
            
         // recursion for main directory 
         listAllFiles(arr,++index, level); 
    } 
}