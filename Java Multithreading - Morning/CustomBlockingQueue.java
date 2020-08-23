import java.io.*;
import java.util.*;
public class CustomBlockingQueue
{
    private Node front;
    private Node rear;
    private int length=0;
    private static int capacity;
    public static void main(String[] args) throws IOException
    {
        Scanner scan=new Scanner(System.in);
        CustomBlockingQueue queue = new CustomBlockingQueue();
        System.out.println("Enter capacity of the Queue");
        capacity=scan.nextInt();
        System.out.println("Enter No of Producers required");
        int producers = scan.nextInt();
        System.out.println("Enter No of Consumers required");
        int consumers = scan.nextInt();
        scan.close();

        for(int i=0;i<producers;i++)
        {
            new Thread(() -> {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for(int i=0;i<consumers;i++)
        {
            new Thread(() -> {
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    public synchronized void put(int data) throws InterruptedException {
        System.out.println("put method called...");
        if(this.length > capacity){
            System.out.println("Queue is full. No task is already taken by any of the consumer.");
            wait();
        }
        Node node = new Node(data);
        if(length==0){
            front = node;
        }else {
            rear.next=node;;
        }
        rear = node;
        length++;
        System.out.println("Data added in the queue. Going to notify the observers.");
        notifyAll();
    }
    public synchronized int take() throws InterruptedException {
        System.out.println("take() method called");
        int data;
        if(length==0){
            System.out.println("Queue is empty. There is no task present in the Queue");
            wait();
        }
        System.out.println("Data became available. take() method resumed.");
        data = front.data;
        front = front.next;
        length--;
        return data;
    }


}
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data; 
    }
}
