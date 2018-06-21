package sorters;

import java.awt.Color;
import java.awt.Graphics;

import controller.Controller;

// Class to QuickSort a list of numbers
public class QuickSort extends SorterBase {
  private int pivot;

  public QuickSort() {
    super();
    this.title = "Quick Sort";
    this.pivot = -1;
  }

  public QuickSort(int size) {
    super(size);
    this.title = "Quick Sort";
  }

  public QuickSort(SorterBase base) {
    super(base);
    this.title = "Quick Sort";
    this.pivot = -1;
  }

  /**
   * Sort the list of numbers with QuickSort.
   * @param isTesting Whether tests are being run or not
   */
  @Override
  public void sort(boolean isTesting) {
    quickSort(0, toSolve.size() - 1, isTesting);
  }

  /**
   * Create a new random QuickSort with the given number of elements.
   * @param size The number of elements to be sorted
   * @return The newly created QuickSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new QuickSort(size);
  }

  private void quickSort(int low, int high, boolean isTesting) {
    if (low < high) {
      int partition = partition(low, high, isTesting);
      if (interrupted) {
        return;
      }
      quickSort(low, partition - 1, isTesting);
      quickSort(partition + 1, high, isTesting);
    }
  }

  /**
   * Swap the low, high, and midpoint of the two so that they are in order.
   * @param low The low index
   * @param high The high index
   * @param isTesting Whether tests are being run or not
   */
  private void medianOfThree(int low, int high, boolean isTesting) {
    int mid = (low + high) / 2;
    if (toSolve.get(mid) < toSolve.get(low)) {
      this.low = low;
      this.high = mid;
      repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
      if (interrupted) {
        return;
      }
      swap(low, mid);
      repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
      if (interrupted) {
        return;
      }
    }
    if (toSolve.get(high) < toSolve.get(low)) {
      this.low = low;
      this.high = high;
      repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
      if (interrupted) {
        return;
      }
      swap(low, high);
      repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
      if (interrupted) {
        return;
      }
    }
    if (toSolve.get(mid) < toSolve.get(high)) {
      this.low = mid;
      this.high = high;
      repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
      if (interrupted) {
        return;
      }
      swap(mid, high);
      repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
      if (interrupted) {
        return;
      }
    }
  }

  /**
   * Partition the numbers into the correct spots by the pivot
   * @param low The low index
   * @param high The high index
   * @param isTesting Whether tests are being run or not
   * @return The index of last element that was partitioned
   */
  private int partition(int low, int high, boolean isTesting) {
    medianOfThree(low, high, isTesting);
    int pivot = toSolve.get(high);
    this.pivot = pivot;

    int i = low - 1;

    for (int j = low; j < high; j++) {
      this.low = i;
      this.high = j;
      repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
      if (interrupted) {
        return -1;
      }
      if (toSolve.get(j) < pivot) {
        i++;
        this.low++;
        repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
        if (interrupted) {
          return -1;
        }
        swap(i, j);
        repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
        if (interrupted) {
          return -1;
        }
      }
    }
    this.low = i + 1;
    this.high = high;
    repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
    if (interrupted) {
      return -1;
    }

    swap(i + 1, high);
    repaintAndSleepMillis(isTesting, this.delay / 2 + 1);
    return i + 1;
  }

  /**
   * Paint the QuickSort with the given Graphics.
   * @param g The Graphics to draw with
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (pivot < toSolve.size() && pivot >= 0) {
      Integer element = toSolve.get(pivot);

      g.setColor(Color.ORANGE);

      int proportion = (int)(element * (Controller.HEIGHT / (double)size));

      g.fillRect(pivot * (Controller.WIDTH / size), Controller.HEIGHT - proportion,
              Controller.WIDTH / size, proportion);

      g.setColor(Color.BLACK);
      g.drawRect(pivot * (Controller.WIDTH / size), Controller.HEIGHT - proportion,
              Controller.WIDTH / size, proportion);
    }
  }
}
