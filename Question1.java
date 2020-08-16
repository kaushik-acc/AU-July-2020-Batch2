import java.io.*;
import java.util.*;
class Question1
{
    public static void main(String[] args) throws IOException
    {
        int a = 5; 
  
        // lambda expression to define the calculate method 
        Square s = (int x)->x*x; 
        int ans = s.calculate(a); 
        System.out.println(ans); 

        // using static method
        Square sq = Question1 :: getSquare;
        System.out.println(sq.calculate(a));

        // using instance method
        Question1 obj=new Question1("Instantiating using instance method");
        Square sq1= obj::square;
        System.out.println(sq1.calculate(a));

        // using Constructor
        Print p=Question1::new;
        p.display("Instantiated Functional Interface using Constructor reference");

    }
    public static int getSquare(int n)
    {
        return n*n;
    }
    public int square(int n)
    {
        return n*n;
    }
    public Question1(String s)
    {
        System.out.println(s);
    }
}

@FunctionalInterface
interface Square{
    int calculate(int x);
}

@FunctionalInterface
interface Print{
    void display(String s);
}