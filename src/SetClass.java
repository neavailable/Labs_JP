import java.util.Set;
import java.util.Iterator;


public class SetClass implements IAddAndShowElements
{
    private Set<Integer> set;

    public SetClass(Set<Integer> set_)
    {
        set = set_;
    }

    @Override
    public void AddElement(Integer element)
    {
        set.add(element);
    }

    @Override
    public void ShowElements()
    {
        Iterator<Integer> i = set.iterator();
        int counter = 1;
        while(i.hasNext())
        {
            System.out.println("Element № " + counter + " = " + i.next());
            ++counter;
        }
    }
}