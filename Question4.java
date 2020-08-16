import java.io.*;
import java.util.*;
class Question4
{
    public static void main(String[] args) throws IOException
    {
        MyClass obj=new MyClass(1, 2, 3, 4, 5);
            //Serialize
        try
        {
            FileOutputStream fileOut = new FileOutputStream("myclass.ser");
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(obj);
            outStream.close();
            fileOut.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }
        
        //Deserialize
        obj=null;
        try
        {
            FileInputStream fileIn =new FileInputStream("myclass.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = (MyClass) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("MyClass class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized MyClass...");
        System.out.println("Field 1="+obj.field1);
        System.out.println("Field 1="+obj.field2);
        System.out.println("Field 1="+obj.field3);
        System.out.println("Field 1="+obj.field4);//will be 0 because transient is used
        System.out.println("Field 1="+obj.field5);//will be 0 because transient is used
    }
}
class MyClass implements Serializable
{
    public static final long serialVersionUID=69L;
    int field1,field2,field3;
    transient int field4,field5;
    MyClass(int f1,int f2,int f3,int f4,int f5)
    {
        field1=f1;
        field2=f2;
        field3=f3;
        field4=f4;
        field5=f5;

    }
}