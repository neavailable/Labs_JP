import java.util.Iterator;
import java.util.List;

public class ListClass implements IAddShowModifyAndRemoveElements
{
    private List<Integer> list;

    public ListClass(List<Integer> list_)
    {
        list = list_;
    }

    @Override
    public void AddElement(Integer element)
    {
        list.add(element);
    }

    @Override
    public void ShowElements()
    {
        Iterator<Integer> i = list.iterator();
        int counter = 1;
        while(i.hasNext())
        {
            System.out.println("Element N " + counter + " = " + i.next());
            ++counter;
        }
    }

    @Override
    public void ModifyElement(int index, Integer number)
    {
        list.set(index, number);
    }

    @Override
    public void RemoveElement(int index)
    {
        list.remove(index);
    }
}
