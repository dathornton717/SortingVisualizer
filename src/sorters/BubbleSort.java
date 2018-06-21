package sorters;

// Class to run BubbleSort on a list of numbers
public class BubbleSort extends SorterBase {
  public BubbleSort() {
    super();
    this.title = "Bubble Sort";
  }

  public BubbleSort(int size) {
    super(size);
    this.title = "Bubble Sort";
  }

  public BubbleSort(SorterBase base) {
    super(base);
    this.title = "Bubble Sort";
  }

  /**
   * Sort the list of numbers using BubbleSort.
   * @param isTesting Whether tests are being run or not
   */
  @Override
  public void sort(boolean isTesting) {
    int size = toSolve.size();
    while (size != 0) {

      int newN = 0;

      for (int i = 1; i < toSolve.size(); i++) {
        this.low = i - 1;
        this.high = i;
        if (toSolve.get(i - 1) > toSolve.get(i)) {
          swap(i - 1, i);
          newN = i;
        }
        repaintAndSleepMillis(isTesting, this.delay);
        if (interrupted) {
          return;
        }
      }
      size = newN;
    }
  }

  /**
   * Create a new BubbleSort with the given size of numbers.
   * @param size The size of the array to sort
   * @return The newly created BubbleSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new BubbleSort(size);
  }
}
