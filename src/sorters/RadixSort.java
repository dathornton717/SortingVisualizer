package sorters;

import java.util.Arrays;

// Class to sort using RadixSort
public class RadixSort extends SorterBase {

  public RadixSort() {
    super();
    this.title = "Radix Sort";
  }

  public RadixSort(int size) {
    super(size);
    this.title = "Radix Sort";
  }

  public RadixSort(SorterBase base) {
    super(base);
    this.title = "Radix Sort";
  }

  /**
   * Sort the list of numbers using RadixSort.
   * @param isTesting Whether tests are being run or not
   */
  @Override
  public void sort(boolean isTesting) {
    this.high = -1;
    int n = toSolve.size();
    int max = getMax(n, isTesting);
    if (interrupted) {
      return;
    }

    for (int exp = 1; max / exp > 0; exp *= 10) {
      countSort(n, exp, isTesting);
    }
  }

  /**
   * Create a new RadixSort with the given number of elements.
   * @param size The number of elements to sort
   * @return The newly created RadixSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new RadixSort(size);
  }

  /**
   * Sort the numbers into bins based on their digits.
   * @param n The number of elements to sort
   * @param exp The current digit
   * @param isTesting Whether tests are being run or not
   */
  private void countSort(int n, int exp, boolean isTesting) {
    int count[] = new int[10];
    int output[] = new int[n];
    Arrays.fill(count, 0);

    for (int i = 0; i < n; i++) {
      this.low = i;
      repaintAndSleepMillis(isTesting, this.delay);
      if (interrupted) {
        return;
      }
      int toSet = (toSolve.get(i) / exp) % 10;
      count[toSet]++;
    }

    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
      this.low = i;
      repaintAndSleepMillis(isTesting, this.delay);
      if (interrupted) {
        return;
      }
      int j = (toSolve.get(i) / exp) % 10;
      int toSet = count[j];
      output[toSet - 1] = toSolve.get(i);
      count[j]--;
    }

    for (int i = 0; i < n; i++) {
      this.low = i;
      repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
      if (interrupted) {
        return;
      }
      toSolve.set(i, output[i]);
      repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
      if (interrupted) {
        return;
      }
    }
  }

  /**
   * Get the max number of the list
   * @param n The number of elements in the list
   * @param isTesting Whether tests are being run or not
   * @return The max number of the list
   */
  private int getMax(int n, boolean isTesting) {
    int max = toSolve.get(0);
    this.low = 0;
    repaintAndSleepMillis(isTesting, this.delay);
    if (interrupted) {
      return -1;
    }
    for (int i = 1; i < n; i++) {
      this.low = i;
      repaintAndSleepMillis(isTesting, this.delay);
      if (interrupted) {
        return -1;
      }
      if (toSolve.get(i) > max) {
        max = toSolve.get(i);
      }
    }
    return max;
  }
}
