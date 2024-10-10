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

        for (int i = 0; i < counter; i++)
        {
            System.out.printf("Podaj liczbe N " + (i + 1) + "  ");
            addAndShowHashSet.AddElement(new Scanner(System.in).nextInt());
        }

        addAndShowHashSet.ShowElements();
    }
}