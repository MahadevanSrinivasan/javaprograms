import java.util.Random;
public class UnorderedArrayMaxPQ<Key extends Comparable<Key>>
{
  private Key[] pq;
  private int size;

  public UnorderedArrayMaxPQ(int capacity)
  {
    pq = (Key[]) new Comparable[capacity];
    size = 0;
  }

  public void insert(Key data)
  {
    pq[size++] = data;
    if(size > pq.length)
    {
      resize(2*size);
    }
  }

  private void resize(int capacity)
  {
    Key[] temp = (Key[]) new Object[capacity];
    for(int i = 0; i < size; i++)
    {
      temp[i] = pq[i];
    }
    pq = temp;
  }

  public boolean less(int i, int j)
  {
    return pq[i].compareTo(pq[j]) < 0;
  }

  public Key delMax()
  {
    int maxIndex = 0;
    for(int i = 1; i < size; i++)
    {
      if (less(maxIndex, i))
        maxIndex = i;
    }

    Key temp = pq[maxIndex];
    pq[maxIndex] = pq[size-1];
    pq[size-1] = temp;
    size--;

    return temp;
  }

  public boolean isEmpty()
  {
    return (size == 0);
  }

  public static void main(String args[])
  {
    UnorderedArrayMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>(10);
    Random rand = new Random();
    for(int i = 0; i < 10; i++)
    {
      int randNum = rand.nextInt(100);
      pq.insert(randNum);
      System.out.print(randNum + " ");
    }
    System.out.println();
    while (!pq.isEmpty())
      System.out.println(pq.delMax());
  }


}
