package sorters;

// Class to sort the list of numbers with StoogeSort
public class StoogeSort extends SorterBase {
  public StoogeSort() {
    super();
    this.title = "Stooge Sort";
  }

  public StoogeSort(int size) {
    super(size);
    this.title = "Stooge Sort";
  }

  public StoogeSort(SorterBase base) {
    super(base);
    this.title = "Stooge Sort";
  }

  /**
   * Sort the list of numbers with StoogeSort.
   * @param isTesting Whether tests are being run or not
   */
  @Override
  public void sort(boolean isTesting) {
    stoogeSort(0, toSolve.size() - 1, isTesting);
  }

  /**
   * Create a new StoogeSort instance with the given number of elements.
   * @param size The number of elements to sort
   * @return The newly created StoogeSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new StoogeSort(size);
  }

  /**
   * Sort the numbers between the low index and high index using stooge sort.
   * @param low The low index
   * @param high The high index
   * @param isTesting Whether tests are being run
   */
  private void stoogeSort(int low, int high, boolean isTesting) {
    this.low = low;
    this.high = high;
    repaintAndSleepNano(isTesting, this.delay);
    if (interrupted) {
      return;
    }
    if (toSolve.get(low) > toSolve.get(high)) {
      repaintAndSleepNano(isTesting, this.delay);
      if (interrupted) {
        return;
      }
      swap(low, high);
      repaintAndSleepNano(isTesting, this.delay);
      if (interrupted) {
        return;
      }
    }

    if ((high - low + 1) > 2) {
      int third = (high - low + 1) / 3;
      stoogeSort(low, high - third, isTesting);
      stoogeSort(low + third, high, isTesting);
      stoogeSort(low, high - third, isTesting);
    }
  }
}
