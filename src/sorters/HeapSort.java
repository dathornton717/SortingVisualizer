package sorters;

// Class to sort a list of numbers with HeapSort
public class HeapSort extends SorterBase {
  public HeapSort() {
    super();
    this.title = "Heap Sort";
  }

  public HeapSort(int size) {
    super(size);
    this.title = "Heap Sort";
  }

  public HeapSort(SorterBase base) {
    super(base);
    this.title = "Heap Sort";
  }

  /**
   * Sort the list of numbers with HeapSort.
   * @param isTesting Whether the sort is being tested or not
   */
  @Override
  public void sort(boolean isTesting) {
    int n = toSolve.size();
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(n, i, isTesting);
    }

    for (int i = n - 1; i >= 0; i--) {
      this.low = 0;
      this.high = i;
      swap(0, i);
      repaintAndSleepMillis(isTesting, this.delay);
      if (interrupted) {
        return;
      }
      heapify(i, 0, isTesting);
    }
  }

  /**
   * Create a new HeapSort with the given number of elements.
   * @param size The number of elements to be sorted
   * @return The newly created HeapSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new HeapSort(size);
  }

  /**
   * Turn the list into a heap.
   * @param n The length of the list
   * @param i the current node we are looking at
   * @param isTesting Whether the sort is being tested or not
   */
  private void heapify(int n, int i, boolean isTesting) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && toSolve.get(l) > toSolve.get(largest)) {
      largest = l;
    }

    if (r < n && toSolve.get(r) > toSolve.get(largest)) {
      largest = r;
    }

    if (largest != i) {
      this.low = i;
      this.high = largest;
      repaintAndSleepMillis(isTesting, this.delay);
      if (interrupted) {
        return;
      }
      swap(i, largest);
      repaintAndSleepMillis(isTesting, this.delay);
      if (interrupted) {
        return;
      }

      heapify(n, largest, isTesting);
    }
  }
}
