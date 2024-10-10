import java.util.HashSet;
import java.util.Iterator;


public class AddAndShowHashSet implements IAddAndShowElements
{
    private HashSet<Integer> hashSet;

    public AddAndShowHashSet(HashSet<Integer> hashSet_)
    {
        hashSet = hashSet_;
    }

    @Override
    public void AddElement(int element)
    {
        hashSet.add(element);
    }

    @Override
    public void ShowElements()
    {
        Iterator<Integer> i = hashSet.iterator();
        int counter = 1;
        while(i.hasNext())
        {
            System.out.println("Element N " + counter + " = " + i.next());
            ++counter;
        }
    }
}
