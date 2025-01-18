import java.util.ArrayList;

public class Queue<E> implements MyQueue<E> {

    private final int maxCapacity;
    private int head;
    private int tail;
    private ArrayList<E> list;

    public Queue(int capacity) {
        this.maxCapacity = capacity+1;
        this.head = 0;
        this.tail = 0;
        this.list = new ArrayList<>(capacity);
    }

    @Override
    public void enqueue(E x) throws FullException {
        int newTail = (tail + 1)%maxCapacity;

        if (newTail == head)
            throw new FullException("Queue is full");

        list.add(tail,x);
        tail = newTail;
    }

    public void dequeue() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Queue is empty");
        }
        head = (head + 1) % maxCapacity;
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty())
            throw new EmptyException("Queue is empty");

        return list.get(head);
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % maxCapacity == head;
    }
}
