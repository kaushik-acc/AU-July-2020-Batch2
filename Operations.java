import java.io.*;
import java.util.*;
class Operations
{
    public static void main(String[] args) throws IOException
    {
        
        String s1="-5+8*6";
        String s2="(55+9)%9";
        String s3="(20+-3*5/8)";
        String s4="5+15/3*2-8%3";
        Operations obj=new Operations();
        System.out.println(obj.evaluate(s1));
        System.out.println(obj.evaluate(s2));
        System.out.println(obj.evaluate(s3));
        System.out.println(obj.evaluate(s4));

        
    }
    public int evaluate(String s)
    {
        char[] ch = s.toCharArray();
        //System.out.print(ch.length+" "); 
  
         
        Stack<Integer> values = new Stack<Integer>(); 
        Stack<Character> ops = new Stack<Character>(); 
        

  
        for (int i = 0; i < ch.length; i++) 
        { 
            if ((ch[i] == '+' || ch[i] == '-') && (i==0 || ch[i-1]=='+' || ch[i-1]=='-'))
            values.push(0);
            if(ch[i]>='0' && ch[i]<='9')
            { 
                StringBuilder build=new StringBuilder();
                while (i < ch.length && ch[i] >= '0' && ch[i] <= '9') 
                    build.append(ch[i++]);
                    i--; 
                values.push(Integer.parseInt(build.toString())); 
                //System.out.print(values.peek()+" ");
            } 
  
        
            else if (ch[i] == '(') 
               {
                   ops.push(ch[i]); 
               }
  
          
            else if (ch[i] == ')') 
            { 
                while (ops.peek() != '(') 
                  values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
                ops.pop(); 
            } 
  

            else if (ch[i] == '+' || ch[i] == '-' || ch[i] == '*' || ch[i] == '/' || ch[i]=='%')
            { 
                //System.out.print("ok");
                while (!ops.isEmpty() && hasPrecedence(ch[i], ops.peek())) 
                  values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
                  //System.out.print(values.peek()+" ");
                ops.push(ch[i]); 
            } 
        }
        
  
        
        while (!ops.isEmpty()) 
            {
                values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
                //System.out.print(values.peek()+" ");
            }
  
        
        return values.pop(); 
    }
    public  boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '%' || op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 
    public int applyOp(char op, int b, int a) 
    { 
        //System.out.print(op+" "+b);
        switch (op) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '/': 
            if (b == 0) 
                throw new
                UnsupportedOperationException("Cannot divide by zero"); 
            return a / b; 
        case '%':  
            return a%b;
        
        } 
        return 0; 
    } 
  

}