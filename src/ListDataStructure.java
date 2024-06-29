import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListDataStructure {

    public static void main(String[] args) {

        // Collection Interface
        // Here are the all abstract methods for collection interface:
        // size, isEmpty, contains, iterator, toArray, add, remove, containsAll, addAll, removeAll
        // removeIf, retainAll, clear, equals, hashCode, spliterator, stream, parallelStream

        Collection<Integer> collection = new ArrayList<>();

        collection.add(1);
        collection.add(2);

        System.out.println("Collection size is : " + collection.size());

        // List Interface
        // List is a built-in interface from the Java package java.util.
        // Like arrays, lists allow you to group and store multiple elements in a collection.
        // However, lists are more powerful and complex, providing advanced storage options and
        // retrieving values.
        // List<E> extends SequencedCollection<E>
        // SequencedCollection<E> extends Collection<E> - enhance following methods add, remove, get
        // from first and also last such as getFirst, removeLast


        // One key difference with arrays is that you can store only objects in lists.
        // Thus, you cannot store a primitive type directly in a list, but instead you have to use
        // its wrapper class.

        List<Integer> list = new ArrayList<>();
        List<Person> list1 = new ArrayList<>();

        // List is an interface, so need to use one of the implementation of List:
        // -> ArrayList - It uses array as internally, but it is growable.
        // -> LinkedList - LinkedList is designed differently with a higher initialization cost
        // regarding resources but more optimal for manipulating data.
        // -> Vector - is synchronized, i.e., it is safe to be used in multi-threaded programs.
        // However, synchronization comes with a performance cost on each operation for manipulating
        // data, and that’s why it should be used only when needed.

        List<Person> personList = new ArrayList<>();
        List<Person> personList2 = new LinkedList<>();
        List<Person> personList3 = new Vector<>();

        // To check list is empty or not, you can use isEmpty method or size method

        System.out.println("The list is empty " + (list.size() == 0));
        System.out.println("The list is empty " + list.isEmpty());

        // To check one object existence we can use contains method

        List<Integer> lst = new ArrayList<>();
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);

        System.out.println("List contains 2 " + lst.contains(2));

        // You can easily revert list with reversed method

        lst.reversed();

        // You can use iterator method to traverse the collection and remove elements safely while traversing

        System.out.println("Element list size is " + lst.size());

        Iterator<Integer> iterator = lst.iterator();
        while (iterator.hasNext()) {
            System.out.println("Element is " + iterator.next());
            iterator.remove();
        }

        System.out.println("Element list size is " + lst.size());

        // To sort collection, you can either use Collections.sort or lst.sort(null) - first one calls the second one
        Collections.sort(lst);
        lst.sort(null);

        // To clear list, you can use clear method:

        List<Integer> lst2 = new ArrayList<>();
        lst2.add(2);
        lst2.add(3);
        lst2.add(4);
        lst2.add(5);

        System.out.println("Element list size is " + lst2.size());
        lst2.clear();
        System.out.println("Element list size after clear is " + lst2.size());

        lst2.add(1);

        // To check if two list equals, we can use equals methods
        System.out.println("Test result is " + lst.equals(lst2));

        // To create list from elements, we can use List.of factory method,
        // but it creates immutable collection so you cannot add/remove new elements to list.

        List<Integer> lst3 = List.of(1,2,3,4,5,6,7,8,9,10,11);

        try {
            lst3.remove(11);
        } catch (UnsupportedOperationException e) {
            System.out.println("Removed element is not supported");
        }


        // ArrayList class
        // Resizable-array implementation of the List interface.
        // In addition to implementing the List interface, this class provides methods to
        // manipulate the size of the array that is used internally to store the list.
        // (This class is roughly equivalent to Vector, except that it is unsynchronized.)

        // As elements are added to an ArrayList, its capacity grows automatically.
        // The details of the growth policy are not specified beyond the fact that
        // adding an element has constant amortized time cost.

        // ArrayList is not synchronized, at least one of the threads modifies the list structurally.
        // To have synchronized list, you can use Collections.synchronizedList instead
        // ArrayList<E> extends AbstractList<E>
        // implements List<E>, RandomAccess, Cloneable, java.io.Serializable

        List<Integer> lst4 = new ArrayList<>(); // default capacity is 10
        List<Integer> synchronizedList = Collections.synchronizedList(lst4);
        synchronizedList.add(10);


        // LinkedList class
        // Doubly-linked list implementation of the List and Deque interfaces.
        // Implements all optional list operations, and permits all elements (including null).
        // Operations that index into the list will traverse the list from the beginning or the end,
        // whichever is closer to the specified index.
        // this implementation is not synchronized
        // To have synchronized list, you can use Collections.synchronizedList instead
        // LinkedList<E> extends AbstractSequentialList<E>
        // implements List<E>, Deque<E>, Cloneable, java.io.Serializable
        // It includes two nodes - first and last (Each node includes element, next and prev nodes.

        List<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.add(25); // add this to last by default FIFO logic from deque

        System.out.println("The first is " + linkedList.getFirst()
                + " and last is " + linkedList.getLast());

        // Deque interface
        // A linear collection that supports element insertion and removal at both ends.
        // The name deque is short for "double ended queue" and is usually pronounced "deck".
        // This interface extends the Queue interface. When a deque is used as a queue,
        // FIFO (First-In-First-Out) behavior results.
        // public interface Deque<E> extends Queue<E>, SequencedCollection<E> {

        Deque<Integer> deque = new LinkedList<>();


        // ArrayDeque<E> extends AbstractCollection<E>
        // implements Deque<E>, Cloneable, Serializable
        // Resizable-array implementation of the Deque interface. Array deques have no capacity restrictions;
        // they grow as necessary to support usage. They are not thread-safe;
        // in the absence of external synchronization, they do not support concurrent access by multiple threads.

        Deque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.offerFirst(10);
        arrayDeque.offerLast(20);
        arrayDeque.poll();

        System.out.println("Peek is " + deque.peek());
        System.out.println("Peeked element is " + deque.pollFirst());

        // Vector class
        // The Vector class implements a growable array of objects.
        // Like an array, it contains components that can be accessed using an integer index.
        // the size of a Vector can grow or shrink as needed to accommodate adding and removing
        // items after the Vector has been created.
        // Vector is synchronized. If a thread-safe implementation is not needed,
        // it is recommended to use ArrayList in place of Vector.
        // It spends more memory and slow compared to ArrayList

        List<Integer> vector = new Vector<>();
    }
}
