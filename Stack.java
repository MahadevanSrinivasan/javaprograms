import java.util.*;

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

  public Node getNode(Item data)
  {
    Node curr = head;
    while(curr != null && curr.item != data)
    {
      curr = curr.next;
    }
    return curr;
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

  public void deleteDuplicates()
  {
    HashMap map = new HashMap();
    Node curr = head;
    Node prev = head;
    while(curr != null)
    {
      if(map.containsKey(curr.item))
      {
        /*
         * If we have seen this element already,
         * prev should remain the same. Only the
         * curr pointer should move. Done outside
         * the if-else.
         */
        prev.next = curr.next;
        count--;
      }
      else
      {
        map.put(curr.item, true);
        prev = curr;
      }
      curr = curr.next;
    }
  }

  public void deleteDuplicatesWithoutMap()
  {
    Node curr = head;
    Node prev = head;
    while(curr != null)
    {
      boolean duplicate = false;
      Node secondCurr = head;
      while(secondCurr != curr)
      {
        if(secondCurr.item == curr.item)
        {
          duplicate = true;
          prev.next = curr.next;
          count--;
          break;
        }
        secondCurr = secondCurr.next;
      }
      if(!duplicate)
      {
        prev = curr;
      }
      curr = curr.next;
    }
  }
  public Node isCircular()
  {
    Node curr1 = head;
    Node curr2 = head;
    /* If the fast moving pointer reaches the end,
       then there is no loop */
    while(curr2.next != null && curr2.next.next != null)
    {
      curr1 = curr1.next;
      curr2 = curr2.next.next;

      /* No way curr1 can be curr2 unless there is a loop */
      if(curr1 == curr2)
      {
        curr1 = head;
        while(curr1 != curr2)
        {
          curr1 = curr1.next;
          curr2 = curr2.next;
        }
        return curr1;
      }
    }
    return null;
  }


  private static class Node<Item>
  {
    private Item item;
    private Node<Item> next;
  }

  public static void main(String[] args)
  {
     Stack<Character> s = new Stack<Character>();
     for(int i = 0; i < args[0].length(); i++)
     {
       s.push(args[0].charAt(i));
     }
     System.out.println("(" + s.size() + " left on stack)");
     System.out.println(s.toString());
     s.deleteDuplicatesWithoutMap();
     System.out.println("(" + s.size() + " left on stack)");
     System.out.println(s.toString());
     System.out.println("IsCircular? : " + s.isCircular());

     Node nodeC = s.getNode('C');
     Node nodeE = s.getNode('E');
     nodeE.next = nodeC;
     System.out.println("IsCircular? : " + s.isCircular().item);
  }
}
