import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item>
{
  private Item[] a;         // array of items
  private int N;            // number of elements on stack

  /**
   * Initializes an empty stack.
   */
  public ResizingArrayStack()
  {
    a = (Item[]) new Object[2];
  }

  /**
   * Is this stack empty?
   * @return true if this stack is empty; false otherwise
   */
  public boolean isEmpty()
  {
    return N == 0;
  }

  // resize the underlying array holding the elements
  private void resize(int capacity)
  {
    System.out.println("Count = "+ (N) + " Time to resize");
    assert capacity >= N;
    Item[] temp = (Item[]) new Object[capacity];
    for (int i = 0; i < N; i++)
    {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(Item item)
  {
    a[N++] = item;
    if(N == a.length)
    {
      resize(N*2);
    }
  }

  public Item pop()
  {
    Item item = a[N-1];
    a[N-1] = null;
    N--;
    if(N > 0 && N < a.length/4)
      resize(N/2);
    return item;
  }

  public int size()
  {
    return N-1;
  }

  public String toString()
  {
    StringBuilder s = new StringBuilder();
    for(Item item: this)
      s.append(item + " ");
    return s.toString();
  }

  public Item peek()
  {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    return a[N-1];
  }

  public Iterator<Item> iterator()
  {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item>
  {
    private int i;
    public ReverseArrayIterator()
    {
     i = N-1;
    }

    public boolean hasNext()
    {
      return (i >= 0);
    }

    public Item next()
    {
      if (!hasNext()) throw new NoSuchElementException();
      return a[i--];
    }
  }

  public static void main(String[] args)
  {
     ResizingArrayStack<Integer> s = new ResizingArrayStack<Integer>();
     for(int i = 0; i < 10; i++)
     {
       s.push(i);
     }
     System.out.println("(" + s.size() + " left on stack)");
     System.out.println(s.toString());
  }
}
