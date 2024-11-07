import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


public class Main {
    private static void Exercise1()
    {
        System.out.println("Zadanie 1");
        System.out.println("Ile liczb chcesz w wprowadzić?:  ");
        int numberOfElements = (new Scanner(System.in)).nextInt();
        SetClass HashSetObject = new SetClass(new HashSet());
        SetClass TreeSetObject = new SetClass(new TreeSet());

        for (int i = 0, element; i < numberOfElements; i++) {
            System.out.println("Wpisz liczbe №" + (i + 1));
            element = (new Scanner(System.in)).nextInt();
            HashSetObject.AddElement(element);
            TreeSetObject.AddElement(element);
        }

        System.out.println("Elemeny w HashSet:");
        HashSetObject.ShowElements();
        System.out.println("Elemeny w TreeSet:");
        TreeSetObject.ShowElements();
    }

    private static void Exercise2()
    {
        System.out.println("Zadanie 2");
        ListClass ArrayListObject = new ListClass(new ArrayList());
        ListClass LinkedListObject = new ListClass(new LinkedList());

        Long ArrayListObjectTime, LinkedListObjectTime;

        System.out.println("Wpisz z iloma elementami chcesz wykonać dodawanie, modyfikowanie oraz usuwanie w kolekcjach");

        final int numberOfElements = (new Scanner(System.in)).nextInt();

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) ArrayListObject.AddElement(0);
        ArrayListObjectTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) LinkedListObject.AddElement(0);
        LinkedListObjectTime = System.currentTimeMillis() - startTime;

        System.out.println("Trwanie dodawania " + numberOfElements + " elementów w ArrayList = " + ArrayListObjectTime);
        System.out.println("Trwanie dodawania " + numberOfElements + " elementów w LinkedList = " + LinkedListObjectTime + '\n');


        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) ArrayListObject.ModifyElement(i, 1);
        ArrayListObjectTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) LinkedListObject.ModifyElement(i, 1);
        LinkedListObjectTime = System.currentTimeMillis() - startTime;

        System.out.println("Trwanie modyfikowania " + numberOfElements + " elementów w ArrayList = " + ArrayListObjectTime);
        System.out.println("Trwanie modyfikowania " + numberOfElements + " elementów w LinkedList = " + LinkedListObjectTime + '\n');


        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) ArrayListObject.RemoveElement(0);
        ArrayListObjectTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) LinkedListObject.RemoveElement(0);
        LinkedListObjectTime = System.currentTimeMillis() - startTime;

        System.out.println("Trwanie usuwania " + numberOfElements + " elementów w ArrayList = " + ArrayListObjectTime);
        System.out.println("Trwanie usuwania " + numberOfElements + " elementów w LinkedList = " + LinkedListObjectTime + '\n');
    }

    private static void Exercise3() {
        System.out.println("Zadanie 3");

        HashMap<String, Integer> hashMap = new HashMap();
        TreeMap<String, Integer> treeMap = new TreeMap();


        String shouldContinue = "", value;
        Integer key;

        while (!shouldContinue.equals("N") && !shouldContinue.equals("n"))
        {
            System.out.println("Wprowadź wartość:");
            value = (new Scanner(System.in)).nextLine();
            System.out.println("Wprowadź klucz:");
            key = Integer.valueOf((new Scanner(System.in)).nextLine());

            hashMap.put(value, key);
            treeMap.put(value, key);

            System.out.println("Jeżeli chcesz skończyć i wypisać wartości wpisz N lub n");
            shouldContinue = (new Scanner(System.in)).nextLine();
        }


        System.out.println("HashMap:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) System.out.println("wartość: " + entry.getValue() + ", klucz: " + entry.getKey());

        System.out.println("\nTreeMap:");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) System.out.println("wartość: " + entry.getValue() + ", klucz: " + entry.getKey());
    }

    private static void Exercise4() {
        HashMap<String, Integer> hashMap = new HashMap<>();


        String shouldContinue = "", value;
        Integer key;
        while (!shouldContinue.equals("N") && !shouldContinue.equals("n"))
        {
            System.out.println("Wprowadź wartość:");
            value = (new Scanner(System.in)).nextLine();
            System.out.println("Wprowadź klucz:");
            key = Integer.valueOf((new Scanner(System.in)).nextLine());

            hashMap.put(value, key);

            System.out.println("Jeżeli chcesz skończyć i wypisać wartości wpisz N lub n");
            shouldContinue = (new Scanner(System.in)).nextLine();
        }


        TreeMap<String, Integer> sortedMap = new TreeMap<>((k1, k2) ->
        {
            int valueCompare = hashMap.get(k1).compareTo(hashMap.get(k2));

            if (valueCompare == 0) return k1.compareTo(k2);
            else return valueCompare;
        }
        );

        sortedMap.putAll(hashMap);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) System.out.println("wartość: " + entry.getValue() + ", klucz: " + entry.getKey());
    }

    private static void RunMainFunctions()
    {
        Exercise1();
        Exercise2();
        Exercise3();
        Exercise4();
    }

    public static void main(String[] args) {
        RunMainFunctions();
    }
}
