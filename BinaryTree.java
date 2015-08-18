import java.util.*;

public class BinaryTree
{
  private Node root;

  private static class Node {
    Node left;
    Node right;
    int data;

    Node(int newData) {
      left = null;
      right = null;
      data = newData;
    }
  }

  public void BinaryTree()
  {
    root = null;
  }

  public Node getRoot()
  {
    return root;
  }
  public boolean lookup(int data) {
    return(lookup(root, data));
  }

  private boolean lookup(Node node, int data) {
    if (node==null) {
      return(false);
    }

    if (data==node.data) {
      return(true);
    }
    else if (data<node.data) {
      return(lookup(node.left, data));
    }
    else {
      return(lookup(node.right, data));
    }
  }

  public void insert(int data) {
    root = insert(root, data);
  }

  private Node insert(Node node, int data) {
    if (node==null) {
      node = new Node(data);
    }
    else {
      if (data <= node.data) {
        node.left = insert(node.left, data);
      }
      else {
        node.right = insert(node.right, data);
      }
    }

    return(node); // in any case, return the new pointer to the caller
  }

  public int size()
  {
    return size(root);
  }

  private int size(Node node)
  {
    if(node == null)
      return 0;
    else
      return 1 + size(node.left) + size(node.right);
  }

  public int maxDepth()
  {
    return maxDepth(root);
  }

  private int maxDepth(Node node)
  {
    if(node == null)
      return 0;
    else
    {
      return Math.max(maxDepth(node.left)+1, maxDepth(node.right)+1);
    }
  }

  public int minValue()
  {
    return minValue(root);
  }

  private int minValue(Node node)
  {
    while(node.left != null)
    {
      node = node.left;
    }
    return node.data;
  }

  public int maxValue()
  {
    return maxValue(root);
  }

  private int maxValue(Node node)
  {
    while(node.right != null)
    {
      node = node.right;
    }
    return node.data;
  }

  public void printTree()
  {
    printTree(root);
    System.out.println();
  }

  /* In order traversal */
  private void printTree(Node node)
  {
    if(node == null)
      return;
    else
    {
      printTree(node.left);
      System.out.print(node.data + " ");
      printTree(node.right);
    }
  }

  public void printPostorder()
  {
    printPostorder(root);
    System.out.println();
  }

  /* Post order traversal */
  private void printPostorder(Node node)
  {
    if(node == null)
      return;
    else
    {
      printPostorder(node.left);
      printPostorder(node.right);
      System.out.print(node.data + " ");
    }
  }


  public static void main(String args[])
  {
    BinaryTree b = new BinaryTree();
    Random rand = new Random();
    int[] inputArr = {4 ,2, 5, 1, 3};
    for(int i = 0; i < 10; i++)
      b.insert(rand.nextInt(100));
    // for(int i = 0; i < inputArr.length; i++)
    //   b.insert(inputArr[i]);

    b.printTree();
    b.printPostorder();
    System.out.println("Min value = " + b.minValue());
    System.out.println("Max value = " + b.maxValue());
    System.out.println("Size of BinaryTree = " + b.size());
    System.out.println("Max Depth of BinaryTree = " + b.maxDepth());
  }

}
