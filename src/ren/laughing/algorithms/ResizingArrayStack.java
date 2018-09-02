package ren.laughing.algorithms;

import java.util.Iterator;

/**
 * 下压堆栈（数组实现）
 * 
 * @author Laughing_Lz
 * @createTime 2018年9月2日
 * @param <E>
 */
public class ResizingArrayStack<E> implements Iterable<E> {

  private E[] items = (E[]) new Object[1];
  private int N = 0;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  /**
   * 动态调整数组大小 保持数组大小与栈大小之比小于一个常数
   * 
   * @param max 调整后的数组长度
   */
  public void resize(int max) {
    E[] temp = (E[]) new Object[max];
    for (int i = 0; i < N; i++) {
      temp[i] = items[i];
    }
    items = temp;
  }

  public void push(E item) {
    if (N == items.length) {
      resize(2 * items.length);
    }
    items[N++] = item;
  }

  public E pop() {
    E item = items[--N];
    // 避免对象游离
    items[N] = null;
    if (N > 0 && N == items.length / 4) {
      resize(items.length / 2);
    }
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
    private int i = N;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public E next() {
      return items[--i];
    }

  }
}
