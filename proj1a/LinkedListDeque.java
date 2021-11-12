public class LinkedListDeque<T> {
  public class NodeDeque {
    public NodeDeque prev;
    public T item;
    public NodeDeque next;

    public NodeDeque(NodeDeque p, T i, NodeDeque n) {
      prev = p;
      item = i;
      next = n;
    }
  }

  private NodeDeque sentinel;
  private int size;

  public LinkedListDeque() {
    sentinel = new NodeDeque(null, null, null);
    sentinel.prev = sentinel;
    sentinel.next = sentinel;
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void addFirst(T item) {
    NodeDeque first = new NodeDeque(sentinel, item, sentinel.next);
    sentinel.next.prev = first;
    sentinel.next = first;
    size += 1;
  }

  public void addLast(T item) {
    NodeDeque last = new NodeDeque(sentinel.prev, item, sentinel);
    sentinel.prev.next = last;
    sentinel.prev = last;
    size += 1;
  }

  public int size() {
    return size;
  }

  public void printDeque() {
    NodeDeque ptr = sentinel.next;
    for (int i = 0; i < size; i += 1) {
      System.out.print(ptr.item + " ");
      ptr = ptr.next;
    }
    System.out.println("");
  }

  public T removeFirst() {
    if (size == 0) {
      return null;
    } else {
      T fi = sentinel.next.item;
      sentinel.next = sentinel.next.next;
      sentinel.next.prev = sentinel;
      size -= 1;
      return fi;
    }
  }

  public T removeLast() {
    if (size == 0) {
      return null;
    } else {
      T li = sentinel.prev.item;
      sentinel.prev = sentinel.prev.prev;
      sentinel.prev.next = sentinel;
      size -= 1;
      return li;
    }
  }

  public T get(int index) {
    if (index < 0 || index > size - 1) {
      return null;
    } else {
      NodeDeque ptr = sentinel.next;
      for (int i = 0; i < index; i += 1) {
        ptr = ptr.next;
      }
      return ptr.item;
    }
  }

  public T getRecursive(int index) {
    if (index < 0 || index > size - 1) {
      return null;
    } else if (index == 0) {
      return sentinel.next.item;
    } else {
      T firstitem = removeFirst();
      T indexitem = getRecursive(index-1);
      addFirst(firstitem);
      return indexitem;
    }

  }

}
