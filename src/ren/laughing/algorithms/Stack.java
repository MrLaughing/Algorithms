package ren.laughing.algorithms;

import java.util.Iterator;

/**
 * 下压堆栈（链表实现）
 * 
 * @author Laughing_Lz
 * @createTime 2018年9月2日
 * @param <E>
 */
public class Stack<E> implements Iterable<E> {

  private Node first;
  private int N;

  private class Node {
    E item;
    Node next;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(E item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  public E pop() {
    E item = first.item;
    first = first.next;
    N--;
    return item;
  }

  /**
   * 实现foreach遍历
   */
  @Override
  public Iterator<E> iterator() {
    return new StackIterator();
  }

  private class StackIterator implements Iterator<E> {

    private Node current = first;

    @Override
    public boolean hasNext() {
      return first != null;
    }

    @Override
    public E next() {
      E item = current.item;
      current = first.next;
      return item;
    }

  }
}
