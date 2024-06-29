import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetDataStructure {

    public static void main(String[] args) {

        // Set interface
        // A collection that contains no duplicate elements.
        // More formally, sets contain no pair of elements e1 and e2 such that e1.equals(e2), and at most one null element.
        // interface Set<E> extends Collection<E>

        Set<Integer> set = new HashSet<>();

        // The Set. of and Set. copyOf static factory methods provide a convenient way to create unmodifiable sets.

        Set<Integer> setWithFactory = Set.of(1,2,3,4);

        List<Integer> lst = List.of(1,2,3,4);

        Set<Integer> setWithCopy = Set.copyOf(lst);

        try {
            setWithCopy.add(5);
        } catch (UnsupportedOperationException ex) {
            System.out.println("You cannot add new element to unmodifiable set");
        }

        System.out.println("Sets are equal " + setWithFactory.equals(setWithCopy));

        // You can use Collections.emptySet to create an empty unmodifiable set
        Set<Integer> emptySet = Collections.emptySet();

        try {
            emptySet.add(5);
        } catch (UnsupportedOperationException ex) {
            System.out.println("You cannot add new element to unmodifiable set");
        }

        // Here is the all implementations of Set interface:
        // -> SortedSet interface
        // -> HashSet class
        // -> TreeSet class

        // SortedSet interface
        // A Set that further provides a total ordering on its elements.
        // The elements are ordered using their natural ordering, or by a Comparator typically provided at sorted set creation time.
        // interface SortedSet<E> extends Set<E>, SequencedSet<E>

        SortedSet<Integer> sortedSet = new TreeSet<>();

        // All elements inserted into a sorted set must implement the Comparable interface
        // (or be accepted by the specified comparator).

        SortedSet<Person> sortedSet2 = new TreeSet<>(Comparator.comparing(Person::getName));

        // SortedSet has the following methods: subSet, headSet, tailSet
        // subSet -> Returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement
        // headSet -> Returns a view of the portion of this set whose elements are strictly less than toElement
        // tailSet -> Returns a view of the portion of this set whose elements are greater than or equal to toElement

        Person john = new Person("John");
        sortedSet2.add(john);
        sortedSet2.add(new Person("Jack"));
        sortedSet2.add(new Person("Jonathan"));
        sortedSet2.add(new Person("Bennice"));
        Person alex = new Person("Alex");
        sortedSet2.add(alex);

        System.out.println("Sorted set is " +
                sortedSet2.subSet(alex, john).stream().map(Person::getName).collect(Collectors.joining(",")));

        System.out.println("Sorted set is " +
                sortedSet2.headSet(alex).stream().map(Person::getName).collect(Collectors.joining(",")));

        System.out.println("Sorted set is " +
                sortedSet2.tailSet(alex).stream().map(Person::getName).collect(Collectors.joining(",")));

        // NavigableSet interface
        // A SortedSet extended with navigation methods reporting the closest matches for given search targets.
        // Methods lower -> less than
        // floor -> less than or equal
        // ceiling -> greater than or equal
        // higher ->  greater than a given element
        // returning null if there is no such element.

        NavigableSet<Person> navigableSet = new TreeSet<>(Comparator.comparing(Person::getName));

        navigableSet.add(john);
        navigableSet.add(new Person("Jack"));
        navigableSet.add(new Person("Jonathan"));
        navigableSet.add(new Person("Bennice"));
        navigableSet.add(alex);


        System.out.println("Floor : " + navigableSet.floor(alex).getName());
        System.out.println("Lower : " + navigableSet.lower(alex));
        System.out.println("Ceiling : " + navigableSet.ceiling(alex).getName());
        System.out.println("Higher : " + navigableSet.higher(alex).getName());

        // TreeSet class
        // A NavigableSet implementation based on a TreeMap. The elements are ordered using their natural ordering,
        // or by a Comparator provided at set creation time, depending on which constructor is used.
        // It is not synchronized.
        // class TreeSet<E> extends AbstractSet<E>
        // implements NavigableSet<E>, Cloneable, java.io.Serializable
        // This implementation provides guaranteed log(n) time cost for the basic operations

        TreeSet<Person> treeSet = new TreeSet<>(Comparator.comparing(Person::getName));


        // HashSet class
        // This class implements the Set interface, backed by a hash table (actually a HashMap instance).
        // It makes no guarantees as to the iteration order of the set; in particular,
        // it does not guarantee that the order will remain constant over time.
        // This class permits the null element.
        // This class offers constant time performance for the basic operations (add, remove, contains and size)
        // class HashSet<E> extends AbstractSet<E>
        // implements Set<E>, Cloneable, java.io.Serializable

        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(alex);
        hashSet.add(john);

        // It is not synchronized.
        // You can use Collections.synchronizedSet as alternative synchronized version of HashSet

        Set<Person> synchronizedSet = Collections.synchronizedSet(hashSet);


        // EnumSet class
        // A specialized Set implementation for use with enum types.
        // All of the elements in an enum set must come from a single enum type that is specified, explicitly or implicitly.
        // Null elements are not permitted. Attempts to insert a null element will throw NullPointerException.
        // EnumSet is not synchronized.
        // abstract sealed class EnumSet<E extends Enum<E>> extends AbstractSet<E>
        //  implements Cloneable, java.io.Serializable permits JumboEnumSet, RegularEnumSet

        EnumSet<Status> enumSet = EnumSet.allOf(Status.class);

    }
}
