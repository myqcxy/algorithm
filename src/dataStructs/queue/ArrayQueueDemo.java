package dataStructs.queue;

import java.util.Queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(10);
        arrayQueue.add(5);

        arrayQueue.show();
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());

        arrayQueue.add(3);
        arrayQueue.add(6);
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());

    }
}
class ArrayQueue{
    private int size;
    private int front;
    private int rear;
    private int [] value;
    public ArrayQueue(int size){
        this.size = size;
        value = new int[size];
        }
    public boolean isFull(){
        return (rear + 1)%size == front;
    }
    public boolean isEmpty(){
        return (rear == size);
    }
    public boolean add(int val){
        if(isFull()) return false;
        else {
            value[rear++] = val;
            rear %= size;
            return true;
        }
    }
    public int get(){
        if(isEmpty()) {
            System.out.println("队列空");
            return 0;
        }
        else {
            int s = front;
            front = (front+1)%size;
            return value[s];
        }
    }
    public int length(){
        return (rear+size-front) % size;
    }
    public void show(){
        for (int i = front; i < front + length(); i++) {
            System.out.printf("%d\t",value[i%size]);
        }
    }

}
