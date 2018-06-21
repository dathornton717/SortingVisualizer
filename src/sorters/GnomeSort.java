package sorters;

// Class to sort list of numbers using GnomeSort
public class GnomeSort extends SorterBase {
  public GnomeSort() {
    super();
    this.title = "Gnome Sort";
  }

  public GnomeSort(int size) {
    super(size);
    this.title = "Gnome Sort";
  }

  public GnomeSort(SorterBase base) {
    super(base);
    this.title = "Gnome Sort";
  }

  /**
   * Sort the list using GnomeSort.
   * @param isTesting Whether tests are being run or not
   */
  @Override
  public void sort(boolean isTesting) {
    int position = 0;
    while (position < toSolve.size()) {
      low = position - 1;
      high = position;
      repaintAndSleepMillis(isTesting, delay);
      if (interrupted) {
        return;
      }
      if (position == 0 || toSolve.get(position) >= toSolve.get(position - 1)) {
        position++;
      }
      else {
        swap(position, position - 1);
        repaintAndSleepMillis(isTesting, delay);
        if (interrupted) {
          return;
        }
        position--;
      }
    }
  }

  /**
   * Create a new GnomeSort with the given number of elements.
   * @param size The number of elements to sort
   * @return The newly created GnomeSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new GnomeSort(size);
  }
}
