package sorters;

// Class to sort using SelectionSort
public class SelectionSort extends SorterBase {
  public SelectionSort() {
    super();
    this.title = "Selection Sort";
  }

  public SelectionSort(int size) {
    super(size);
    this.title = "Selection Sort";
  }

  public SelectionSort(SorterBase base) {
    super(base);
    this.title = "Selection Sort";
  }

  /**
   * Sort the list of numbers using SelectionSort.
   * @param isTesting Whether tests are being run or not
   */
  @Override
  public void sort(boolean isTesting) {
    for (int i = 0; i < toSolve.size() - 1; i++) {
      this.low = i;
      int minVal = toSolve.get(i);
      int minIdx = i;
      for (int j = i + 1; j < toSolve.size(); j++) {
        this.high = j;
        if (toSolve.get(j) < minVal) {
          minVal = toSolve.get(j);
          minIdx = j;
        }
        repaintAndSleepMillis(isTesting, this.delay);
        if (interrupted) {
          return;
        }
      }

      swap(i, minIdx);
      repaintAndSleepMillis(isTesting, this.delay);
      if (interrupted) {
        return;
      }
    }
  }

  /**
   * Create a new SelectionSort with the given number of elements.
   * @param size The number of elements to sort
   * @return The newly created SelectionSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new SelectionSort(size);
  }
}
