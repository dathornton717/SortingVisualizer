package sorters;

import java.util.Collections;
import java.util.List;

// Class to run BogoBogoSort on the list of numbers
public class BogoBogoSort extends SorterBase {
  public BogoBogoSort() {
    super();
    this.title = "Bogobogo Sort";
    this.low = -1;
    this.high = -1;
  }

  public BogoBogoSort(int size) {
    super(size);
    this.title = "Bogobogo Sort";
  }

  public BogoBogoSort(SorterBase base) {
    super(base);
    this.title = "Bogobogo Sort";
    this.low = -1;
    this.high = -1;
  }

  /**
   * Sort the list of numbers with BogoBogoSort.
   * @param isTesting Whether tests are being run or not
   */
  @Override
  public void sort(boolean isTesting) {
    // A list of size 1 is always sorted
    if (toSolve.size() == 1) {
      return;
    }

    int index = 2;
    while (!isSorted(toSolve)) {
      // Sort a list of size index
      bogoSort(toSolve.subList(0, index));
      repaintAndSleepMillis(isTesting, delay);
      if (interrupted) {
        return;
      }

      // We are done sorting at this point
      if (index == toSolve.size() && isSorted(toSolve)) {
        break;
      }
      index++;

      // If we are not done try with an index + 1, then restart
      if (!isSorted(toSolve.subList(0, index))) {
        Collections.shuffle(toSolve.subList(0, index));
        repaintAndSleepMillis(isTesting, delay);
        if (interrupted) {
          return;
        }
        index = 2;
      }
    }
  }

  /**
   * Generate a new BogoBogoSort with a new list of numbers.
   * @param size The size of the list of numbers to create
   * @return A new BogoBogoSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new BogoBogoSort(size);
  }

  /**
   * Sort the given list with BogoSort.
   * @param list The list to sort
   */
  private void bogoSort(List<Integer> list) {
    while (!isSorted(list)) {
      Collections.shuffle(list);
    }
  }

  /**
   * Is the given list sorted?
   * @param list The list to check
   * @return If the given list is sorted or not
   */
  private boolean isSorted(List<Integer> list) {
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) < list.get(i - 1)) {
        return false;
      }
    }
    return true;
  }
}
