import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayDataStructure {

    public static void main(String[] args) {

        // Arrays are actually not part of Java collections.

        // Array is the most important data structure.
        // It is also used by other data structures such as HashTable, List, etc.

        // An array is a finite and ordered collection of homogeneous data elements.
        // It is finite because it contains a limited number of elements.
        // It is ordered because all the elements are stored one by one in a contiguous location of computer memory (heap) in a linear fashion.
        // It is homogeneous because all elements of an array are of the same data type only.
        // We can store either primitive types or object references into it.

        int[] myArray = new int[10];
        int[] myArr = new int[]{1,2,3};

        System.out.println("Array length is " + myArray.length);

        myArray[0] = 10;
        myArray[9] = 20;

        System.out.println("Element at index 0 : " + myArray[0]);
        System.out.println("Element at index 9 : " + myArray[9]);

        try {
            myArray[10] = 35;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("IndexOutOfBoundException caught because array length is 10, and maximum index is 9 : ");
        }

        Integer[] myArray2 = new Integer[10];

        // Arrays are generally categorized into two parts: single dimensional array - multi dimensional array(2d or 3d)

        int[][] myArray3 = new int[5][5];
        int[][] myArr2 = new int[][]{{1,2}, {3,4}, {4,5}};
        myArray3[0][1] = 5;

        System.out.println("Element at index 0 at first dimension and 1 at second dimension : " + myArray3[0][1]);


        // To copy an array, there are two ways:
        // First is manually by iterating over the array.
        // Second is by using the arrayCopy() method.  Using the arrayCopy() method of the System class is the fastest way to copy an array
        // and also allows us to copy a part of the array.

        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 2;

        System.out.println("Main array elements : "
                + Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        int[] referencedArr = new int[arr.length];
        referencedArr = arr; // do not copy elements, only makes copiedArr to refer arr location.

        System.out.println("Referenced array elements : "
                + Arrays.stream(referencedArr).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        // First way
        int[] copiedArr = new int[arr.length];
        for (int i = 0; i < referencedArr.length; i++) {
            copiedArr[i] = arr[i];
        }

        System.out.println("Copied array elements : "
                + Arrays.stream(copiedArr).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        // Second way

        int[] copiedArr2 = new int[arr.length];
        System.arraycopy(arr,0, copiedArr2, 0, arr.length);

        System.out.println("System copied array elements : "
                + Arrays.stream(copiedArr2).mapToObj(String::valueOf).collect(Collectors.joining(",")));


        // You can sort array by using Array.sort - You can pass comparator object, otherwise it uses natural ordering.

        Arrays.sort(arr);

        // Convert List to Array with toArray method and array to list with toList method;

        List<Integer> list = new ArrayList<>();
        Integer[] array = list.toArray(new Integer[0]);
        Integer[] array1 = list.toArray(Integer[]::new);

        List<Integer> list1 = Arrays.stream(array1).toList();

        // You can also use streams with array either use static Arrays.stream(arr) method or Stream.of factory method

        Arrays.stream(arr);
        Stream.of(arr);

        // Search an element in sorted list takes O(logn) time with binary search

        System.out.println("Searched element index is " + Arrays.binarySearch(arr, 1));

        // Two check two arrays equals, you can use Arrays.equals method

        System.out.println("Two arrays are equal " + Arrays.equals(array, array1));

        // You can convert String to char array with toCharArray method, you can convert char array to string with String.valueOf method

        String test = "test";

        char[] charArray = test.toCharArray();

        String test2 = String.valueOf(charArray);

        System.out.println("Test is " + test.equals(test2));

        // Add or remove element at middle takes O(n) time - because you need to shift elements after specific index to right(for add) or left(for remove)
    }
}
