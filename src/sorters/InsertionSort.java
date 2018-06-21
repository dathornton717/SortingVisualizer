package sorters;

// Class to sort a list of numbers with InsertionSort.
public class InsertionSort extends SorterBase {

  public InsertionSort() {
    super();
    this.title = "Insertion Sort";
  }

  public InsertionSort(int size) {
    super(size);
    this.title = "Insertion Sort";
  }

  public InsertionSort(SorterBase base) {
    super(base);
    this.title = "Insertion Sort";
  }

  /**
   * Sort the list of numbers with InsertionSort.
   * @param isTesting Whether we are testing or not
   */
  @Override
  public void sort(boolean isTesting) {
    for (int i = 1; i < this.toSolve.size(); i++) {
      Integer value = this.toSolve.get(i);
      int j = i - 1;
      this.low = j;
      this.high = i + 1;
      repaintAndSleepMillis(isTesting, this.delay);
      if (interrupted) {
        return;
      }

      while (j >= 0 && this.toSolve.get(j) > value) {
        toSolve.set(j + 1, toSolve.get(j));
        j--;
        this.low = j;
        repaintAndSleepMillis(isTesting, this.delay);
        if (interrupted) {
          return;
        }
      }

      toSolve.set(j + 1, value);
      repaintAndSleepMillis(isTesting, this.delay);
      if (interrupted) {
        return;
      }
    }
  }

  /**
   * Create a new random InsertionSort with the given number of elements.
   * @param size The number of elements to be sorted
   * @return The newly created InsertionSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new InsertionSort(size);
  }
}
