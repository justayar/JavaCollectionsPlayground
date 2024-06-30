import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapDataStructure {

    public static void main(String[] args) {

        // Map Interface
        // An object that maps keys to values.
        // A map cannot contain duplicate keys; each key can map to at most one value.
        // This interface takes the place of the Dictionary class, which was a totally abstract class rather than an interface

        Map<String, String> map = new HashMap<>();

        // Map interface provides three collection views: keySet, values, entrySet

        map.keySet();
        map.entrySet();
        map.values();


        // Order is not guaranteed. Some map implementations, like the TreeMap class,
        // make specific guarantees as to their encounter order; others, like the HashMap class, do not.
        // Maps with a defined encounter order are generally subtypes of the SequencedMap interface.

        Map<String, String> treeMap = new TreeMap<>();
        Map<Person, String> treeMap2 = new TreeMap<>(Comparator.comparing(Person::getName).thenComparing(Person::getAge));



        Map<String, List<String>> mapWithList = new HashMap<>();

        mapWithList.put("test", List.of("test"));
        mapWithList.get("test");
        mapWithList.remove("test");

        boolean isExist = mapWithList.containsKey("test");
        boolean isExist2 = mapWithList.containsValue(List.of("test"));

        mapWithList.putIfAbsent("test",  new ArrayList<>());
        mapWithList.getOrDefault("test", null);

        mapWithList.computeIfAbsent("key", k -> new ArrayList<>());

        mapWithList.clear();

        // The Map. of, Map. ofEntries, and Map. copyOf static factory methods provide a convenient way to create unmodifiable maps.
        // They disallow null keys and values. Attempts to create them with null keys or values result in NullPointerException.

        Map<String, String> mapWithFactory = Map.of("testKey1", "testVal1", "testKey2", "testVal2");


        // SortedMap interface
        // A Map that further provides a total ordering on its keys. The map is ordered according to the natural ordering
        // of its keys, or by a Comparator typically provided at sorted map creation time.
        // This interface is the map analogue of SortedSet
        // It has three methods: headMap, tailMap, subMap
        // headMap: Returns a view of the portion of this map whose keys are strictly less than toKey
        // tailMap: Returns a view of the portion of this map whose keys are greater than or equal to fromKey.
        // subMap: Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive

        SortedMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put("test1", "testVal1");
        sortedMap.put("test2", "testVal2");
        sortedMap.put("test5", "testVal5");
        sortedMap.put("test3", "testVal3");
        sortedMap.put("test4", "testVal4");

        System.out.println("HeadMap " + sortedMap.headMap("test3").values().stream().collect(Collectors.joining(",")));
        System.out.println("TailMap " + sortedMap.tailMap("test3").values().stream().collect(Collectors.joining(",")));
        System.out.println("SubMap " + sortedMap.subMap("test3", "test5").values().stream().collect(Collectors.joining(",")));


        // Map implementations:
        // -> HashMap - implemented as a hash table, and there is no ordering on keys or values.
        // -> TreeMap - implemented based on red-black tree structure, and it is ordered by the key.
        // -> Hashtable - synchronized in contrast to HashMap and not permits null
        // -> LinkedHashMap - preserves the insertion order
        // -> ConcurrentHashMap - A hash table supporting full concurrency of retrievals and high expected concurrency for updates.

        // class HashMap<K,V> extends AbstractMap<K,V>
        // implements Map<K,V>, Cloneable, Serializable

        // class TreeMap<K,V>
        // extends AbstractMap<K,V>
        // implements NavigableMap<K,V>, Cloneable, java.io.Serializable

        // class Hashtable<K,V>
        // extends Dictionary<K,V>
        // implements Map<K,V>, Cloneable, java.io.Serializable {

        // class LinkedHashMap<K,V>
        // extends HashMap<K,V>
        // implements SequencedMap<K,V>

        // class ConcurrentHashMap<K,V> extends AbstractMap<K,V>
        // implements ConcurrentMap<K,V>, Serializable {

    }
}
