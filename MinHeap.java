import java.util.*;

public class MinHeap
{

  private int[] heap;
  private int heapSize;

  public MinHeap(int capacity)
  {
    heap = new int[capacity+1];
    heap[0] = 0;
    heapSize = 0;
  }

  public MinHeap()
  {
    this(1);
  }

  public void insert(int data)
  {
    heap[++heapSize] = data;
    percUp(heapSize);
    if(heapSize == heap.length-1)
      resize(heap.length * 2);
  }

  private void resize(int capacity)
  {
    int[] temp = new int[capacity];
    for(int i = 0; i <= heapSize; i++)
    {
      temp[i] = heap[i];
    }
    heap = temp;
  }

  private void percUp(int i)
  {
    while ((i / 2) > 0)
    {
      if(heap[i] < heap[i/2])
      {
        swap(i/2, i);
      }
      i = i / 2;
    }
  }

  public int delMin()
  {
    int returnVal = heap[1];
    heap[1] = heap[heapSize];
    heapSize--;
    percDown();
    if(heapSize > 0 && heapSize == (heap.length-1)/4)
      resize(heap.length/2);
    return returnVal;
  }

  private void percDown()
  {
    int i = 1;
    while(2*i <= heapSize)
    {
      int j = 2*i;
      if(j < heapSize && (heap[j] > heap[j+1])) j++;
      if(heap[j] > heap[i]) break;
      swap(i, j);
      i = j;
    }
  }

  private void swap(int i, int j)
  {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  public void printHeap()
  {
    for(int i : heap)
      System.out.print(i + " ");
    System.out.println();
  }

  public boolean isEmpty()
  {
    return (heapSize == 0);
  }

  public static void main(String args[])
  {
    MinHeap h = new MinHeap();
    Random rand = new Random();

    for(int i = 20; i > 0; i--)
    {
      int randNum = rand.nextInt(100);
      h.insert(randNum);
    }
    while(!h.isEmpty())
    {
      System.out.print(h.delMin() + " ");
    }
    System.out.println();

  }
}
