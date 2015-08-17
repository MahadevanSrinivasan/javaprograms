import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>
{
  private Node<Item> head;
  private int count;
  public void Stack()
  {
    head = null;
    count = 0;
  }

  public void push(Item item)
  {
    Node<Item> node = new Node<Item>();
    node.item = item;
    node.next = head;
    head = node;
    count++;
  }
  
  public Item pop()
  {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    Item item = head.item;
    head = head.next;
    count--;
    return item;
  }

  public String toString()
  {
    StringBuilder s = new StringBuilder();
    for (Item item : this)
        s.append(item + " ");
    return s.toString();
  }

  public Boolean isEmpty()
  {
    return (head == null);
  }

  public int size()
  {
    return count;
  }

  public Iterator<Item> iterator()
  {
    return new ListIterator<Item>(head);
  }

  // an iterator, doesn't implement remove() since it's optional
  private class ListIterator<Item> implements Iterator<Item>
  {
    private Node<Item> current;

    public ListIterator(Node<Item> head)
    {
      current = head;
    }

    public boolean hasNext()
    {
      return current != null;
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }

    public Item next()
    {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  private static class Node<Item>
  {
    private Item item;
    private Node<Item> next;
  }

  public static void main(String[] args)
  {
     Stack<Integer> s = new Stack<Integer>();
     for(int i = 0; i < 10; i++)
     {
       s.push(i);
     }
     System.out.println("(" + s.size() + " left on stack)");
     System.out.println(s.toString());
  }
}
