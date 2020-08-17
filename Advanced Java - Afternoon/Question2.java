import java.io.*;
import java.util.*;
class Question2
{
    public static void main(String[] args) throws IOException
    {
        int nonFinalVariable=1;
        final int finalVariable=1;
        int effectivelyFinalVariable=1;
        ArrayList<Node> list=new ArrayList<>();
        for(int i=0;i<10;i++)
        list.add(new Node(i));
        list.forEach(node->{
        node.data++;//instance variable can be changed
        //nonFinalVariable++;//can't use non final variable(error if we uncomment this line)
        //finalVariable++;//can't update final variable(error if we uncomment this line)
        node.data=finalVariable;//can use final variable
        node.data=effectivelyFinalVariable;// can use effectively final variable
        });
        list.forEach(node->System.out.println(node.data));// Every node's data changes to 1

    }
}
class Node
{
    int data;
    Node(int data)
    {
        this.data=data;
    }
}