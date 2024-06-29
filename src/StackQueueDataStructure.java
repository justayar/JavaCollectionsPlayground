import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackQueueDataStructure {

    public static void main(String[] args) {

        // Stack class
        // The Stack class represents a last-in-first-out (LIFO) stack of objects.
        // It extends class Vector with five operations that allow a vector to be treated as a stack.
        // Stack<E> extends Vector<E>
        // The usual push and pop operations are provided, as well as a method to peek at the top item on the stack,
        // a method to test for whether the stack is empty, and a method to search the stack for an item and
        // discover how far it is from the top.
        // When a stack is first created, it contains no items.
        // Stack is synchronized.

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        System.out.println("Peek element is " + stack.peek());
        System.out.println("Popped element is " + stack.pop());

        //  More complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations,
        //  which should be used in preference to this class. For example:

        Deque<Integer> stack2 = new ArrayDeque<>(); // default is FIFO if you use poll and push

        // Queue interface
        // Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner.
        // Among the exceptions are priority queues, which order elements according to a supplied comparator, or the elements'
        // natural ordering, and LIFO queues (or stacks) which order the elements LIFO (last-in-first-out).
        // Whatever the ordering used, the head of the queue is that element which would be removed by a call to remove() or poll().
        // In a FIFO queue, all new elements are inserted at the tail of the queue. Other kinds of queues may use different placement
        // rules. Every Queue implementation must specify its ordering properties.
        // Queue implementations generally do not allow insertion of null elements, although some implementations,
        // such as LinkedList, do not prohibit insertion of null. Even in the implementations that permit it, null should not be
        // inserted into a Queue, as null is also used as a special return value by the poll method to indicate that the queue
        // contains no elements.
        // Queue methods: add, offer, remove, poll, element, peek

        // Difference between add and offer:
        // That when element can not be added to collection the add method throws an exception and offer doesn't.

        Queue<Integer> queue = new ArrayDeque<>();

        try {
            queue.add(null);
            queue.offer(null);
        } catch (NullPointerException e) {
            System.out.println("Cannot add null element to queue");
        }


        // Difference between remove and poll:
        // If the queue is empty, then remove throws NoSuchElementException, otherwise poll returns null.

        Queue<Integer> queue2 = new LinkedList<>();

        try {
            queue2.remove();
        } catch (NoSuchElementException e) {
            System.out.println("There is no element in queue");
        }

        System.out.println("Returns null " + (queue2.poll() == null));

        // Difference between element and peek:
        // If the queue is empty, then element throws NoSuchElementException, otherwise peek returns null.

        try {
            queue2.element();
        } catch (NoSuchElementException e) {
            System.out.println("There is no element in queue");
        }

        System.out.println("Returns null " + (queue2.peek() == null));

        // PriorityQueue class
        // An unbounded priority queue based on a priority heap.
        // The elements of the priority queue are ordered according to their natural ordering,
        // or by a Comparator provided at queue construction time, depending on which constructor is used.
        // A priority queue does not permit null elements.
        // A priority queue is unbounded, but has an internal capacity governing the size of an array used
        // to store the elements on the queue.
        // As elements are added to a priority queue, its capacity grows automatically.
        // PriorityQueue is not synchronized.
        // Implementation note: this implementation provides O(log(n)) time for the enqueuing and dequeuing methods
        // PriorityQueue<E> extends AbstractQueue<E>
        // implements java.io.Serializable
        // abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder()); // descending

        PriorityQueue<Person> pq3 = new PriorityQueue<>(
                Comparator.comparing(Person::getName).thenComparing(Person::getAge));


    }
}
