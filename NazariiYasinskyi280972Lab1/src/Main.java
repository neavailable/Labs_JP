import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeSet;

public class Main
{
    public static void main(String[] args)
    {
        System.out.printf("Ile liczb chcesz w wprowadzić?:  ");
        Integer counter = new Scanner(System.in).nextInt();

        AddAndShowHashSet addAndShowHashSet = new AddAndShowHashSet(new HashSet<Integer>());
        AddAndShowTreeSet addAndShowTreeSet = new AddAndShowTreeSet(new TreeSet<Integer>());

        for (int i = 0; i < counter; i++)
        {
            System.out.printf("Podaj liczbe N " + (i + 1) + "  ");
            Integer element = new Scanner(System.in).nextInt();
            addAndShowHashSet.AddElement(element);
            addAndShowTreeSet.AddElement(element);
        }

        System.out.println("Elemeny w HashSet:");
        addAndShowHashSet.ShowElements();
        System.out.println("Elemeny w HashSet:");
        addAndShowTreeSet.ShowElements();
    }
}