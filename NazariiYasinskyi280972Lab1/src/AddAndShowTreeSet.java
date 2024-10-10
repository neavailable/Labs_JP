import java.util.TreeSet;
import java.util.Iterator;


public class AddAndShowTreeSet implements IAddAndShowElements
{
    private TreeSet<Integer> treeSet;

    public AddAndShowTreeSet(TreeSet<Integer> hashSet_)
    {
        treeSet = hashSet_;
    }

    @Override
    public void AddElement(Integer element)
    {
        treeSet.add(element);
    }

    @Override
    public void ShowElements()
    {
        Iterator<Integer> i = treeSet.iterator();
        int counter = 1;
        while(i.hasNext())
        {
            System.out.println("Element N " + counter + " = " + i.next());
            ++counter;
        }
    }
}
