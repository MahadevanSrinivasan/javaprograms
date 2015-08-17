import java.util.*;

public class TowersOfHanoi
{
  public static int count = 0;
  public static void moveTower(int height, LinkedList<Integer> fromPole, LinkedList<Integer> toPole, LinkedList<Integer> withPole)
  {
    count = count + 1;
    if(height >= 1)
    {
      moveTower(height-1, fromPole, withPole, toPole);
      toPole.push(fromPole.pop());
      moveTower(height-1, withPole, toPole, fromPole);
    }
  }
  public static void printStack(LinkedList<Integer> stackA)
  {
    for(int i = 0; i < stackA.size(); i++)
    {
      System.out.print(stackA.get(i) + " -> ");
    }
    System.out.println("NULL");
  }
  public static void printStacks(LinkedList<Integer> stackA, LinkedList<Integer> stackB, LinkedList<Integer> stackC)
  {
    System.out.print("stackA: ");printStack(stackA);
    System.out.print("stackB:");printStack(stackB);
    System.out.print("stackC: ");printStack(stackC);
  }

  public static void main(String args[])
  {
    LinkedList<Integer> stackA = new LinkedList<Integer>();
    LinkedList<Integer> stackB = new LinkedList<Integer>();
    LinkedList<Integer> stackC = new LinkedList<Integer>();

    for(int i = 3; i >= 1; i--)
    {
      stackA.push(i);
    }
    System.out.println("Before");
    printStacks(stackA, stackB, stackC);
    moveTower(3, stackA, stackC, stackB);
    System.out.println("After");
    printStacks(stackA, stackB, stackC);
    System.out.println("No. of calls = " + count);

  }
}
