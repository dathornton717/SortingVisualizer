package sorters;

import java.util.Collections;

// Class to run BogoSort on a list of numbers
public class BogoSort extends SorterBase {
  public BogoSort() {
    super();
    this.title = "Bogo Sort";
    this.low = -1;
    this.high = -1;
  }

  public BogoSort(int size) {
    super(size);
    this.title = "Bogo Sort";
  }

  public BogoSort(SorterBase base) {
    super(base);
    this.title = "Bogo Sort";
    this.low = -1;
    this.high = -1;
  }

  /**
   * Sort the list of numbers with BogoSort.
   * @param isTesting Whether JUnit tests are being run or not
   */
  @Override
  public void sort(boolean isTesting) {
    // Shuffle the list randomly until it is sorted
    while (!isSorted()) {
      Collections.shuffle(toSolve);
      repaintAndSleepMillis(isTesting, this.delay);
      if (interrupted) {
        return;
      }
    }
  }

  /**
   * Create a new BogoSort with the given size of numbers.
   * @param size The size of the list of numbers to sort
   * @return A new BogoSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new BogoSort(size);
  }

  /**
   * Is the list to solve sorted?
   * @return Whether the list is sorted
   */
  private boolean isSorted() {
    for (int i = 1; i < toSolve.size(); i++) {
      if (toSolve.get(i) < toSolve.get(i - 1)) {
        return false;
      }
    }
    return true;
  }
}
