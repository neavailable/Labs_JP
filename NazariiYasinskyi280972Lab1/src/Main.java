import java.util.*;
import java.util.List;


public class Main
{
    private static ArrayList AddElements(int numberOfElements, IAddAndShowElements collection1, IAddAndShowElements collection2)
    {
        ArrayList<Long> collection1Durations = new ArrayList<Long>();
        ArrayList<Long> collection2Durations = new ArrayList<Long>();

        Long startTime, endTime;
        for (int i = 0; i < numberOfElements; i++)
        {
            System.out.printf("Podaj liczbe N " + (i + 1) + "  ");
            Integer element = new Scanner(System.in).nextInt();

            startTime = System.currentTimeMillis();
            collection1.AddElement(element);
            endTime = System.currentTimeMillis();
            collection1Durations.add(endTime - startTime);

            startTime = System.currentTimeMillis();
            collection2.AddElement(element);
            endTime = System.currentTimeMillis();
            collection2Durations.add(endTime - startTime);
        }

        double collection1DurationsAverage = 0, collection2DurationsAverage = 0;
        for (int i = 0; i < collection1Durations.size(); i++)
        {
            collection1DurationsAverage += collection1Durations.get(i);
            collection2DurationsAverage += collection2Durations.get(i);
        }

        collection1DurationsAverage /= collection1Durations.size();
        collection2DurationsAverage /= collection2Durations.size();

        ArrayList<Double> Durations = new ArrayList<Double>();
        Durations.add(collection1DurationsAverage);
        Durations.add(collection2DurationsAverage);

        return Durations;
    }

    private static void Exercise1(int numberOfElements)
    {
        SetClass HashSetObject = new SetClass(new HashSet<Integer>()),
                TreeSetObject = new SetClass(new TreeSet<Integer>());

        AddElements(numberOfElements, HashSetObject, TreeSetObject);

        System.out.println("Elemeny w HashSet:");
        HashSetObject.ShowElements();
        System.out.println("Elemeny w TreeSet:");
        TreeSetObject.ShowElements();
    }

    private static void Exercise2(int numberOfElements)
    {
        ListClass ArrayListObject = new ListClass(new ArrayList<Integer>()),
                LinkedListObject = new ListClass(new LinkedList<Integer>());

        List<Double> Durations = AddElements(numberOfElements, ArrayListObject, LinkedListObject);
        System.out.println("Trwanie dodania elementu ArrayList: " + Durations.get(0));
        System.out.println("Trwanie dodania elementu LinkedList: " + Durations.get(1));

        int index;
        Integer value;
        do
        {
            System.out.println("Wprowadź indeks elementu, który chcesz zmodyfikować oraz znaczenie");
            index = new Scanner(System.in).nextInt();
            value = new Scanner(System.in).nextInt();
        } while (index >= numberOfElements);


        ArrayListObject.ModifyElement(index, value);
        LinkedListObject.ModifyElement(index, value);

        do
        {
            System.out.println("Wprowadź indeks elementu, który chcesz usunac");
            index = new Scanner(System.in).nextInt();
        } while (index >= numberOfElements);

        ArrayListObject.RemoveElement(index);
        LinkedListObject.RemoveElement(index);


    }

    private static int ShowExerciseInformation(int currentExercise)
    {
        System.out.println("Zadanie " + currentExercise);

        System.out.printf("Ile liczb chcesz w wprowadzić?:  ");

        return new Scanner(System.in).nextInt();
    }


    private static void RunMainLoop()
    {
        //Exercise1(ShowExerciseInformation(1));

        Exercise2(ShowExerciseInformation(2));
    }

    public static void main(String[] args)
    {
        RunMainLoop();
    }
}