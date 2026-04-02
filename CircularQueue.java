package exercise2;
import java.util.Scanner;
public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int count;
    private int maxSize;

    public CircularQueue(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            rear = (rear + 1) % maxSize;
            queue[rear] = item;
            count++;
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            int temp = queue[front];
            front = (front + 1) % maxSize;
            count--;
            return temp;
        }
    }

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == maxSize;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        CircularQueue q = new CircularQueue(size);

        for (int i = 0; i < size; i++) {
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            q.insert(value);
        }

        System.out.println("Removed element: " + q.remove());

        System.out.print("Enter new value to insert: ");
        int newValue = sc.nextInt();
        q.insert(newValue);

        System.out.println("Front element: " + q.peekFront());
    }
}

