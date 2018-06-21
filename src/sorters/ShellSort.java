package sorters;

// Class to sort using ShellSort
public class ShellSort extends SorterBase {
  public ShellSort() {
    super();
    this.title = "Shell Sort";
  }

  public ShellSort(int size) {
    super(size);
    this.title = "Shell Sort";
  }

  public ShellSort(SorterBase base) {
    super(base);
    this.title = "Shell Sort";
  }

  /**
   * Sort the list of numbers using ShellSort.
   * @param isTesting Whether tests are being run or not
   */
  @Override
  public void sort(boolean isTesting) {
    int n = toSolve.size();

    for (int gap = n / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < n; i++) {
        int value = toSolve.get(i);

        int j;
        for (j = i; j >= gap && toSolve.get(j - gap) > value; j -= gap) {
          low = j - gap;
          high = j;
          repaintAndSleepMillis(isTesting, delay);
          if (interrupted) {
            return;
          }
          toSolve.set(j, toSolve.get(j - gap));
          repaintAndSleepMillis(isTesting, delay);
          if (interrupted) {
            return;
          }
        }

        toSolve.set(j, value);
        repaintAndSleepMillis(isTesting, delay);
        if (interrupted) {
          return;
        }
      }
    }
  }

  /**
   * Create a new ShellSort with the given number of elements.
   * @param size The number of elements to sort
   * @return The newly created ShellSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new ShellSort(size);
  }
}
