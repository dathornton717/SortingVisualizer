package sorters;

// Class to sort using CocktailShakerSort
public class CocktailShakerSort extends SorterBase {
  public CocktailShakerSort() {
    super();
    this.title = "Cocktail Shaker Sort";
  }

  public CocktailShakerSort(int size) {
    super(size);
    this.title = "Cocktail Shaker Sort";
  }

  public CocktailShakerSort(SorterBase base) {
    super(base);
    this.title = "Cocktail Shaker Sort";
  }

  /**
   * Sort the list of numbers using CocktailShakerSort.
   * @param isTesting Whether tests are being run or not
   */
  @Override
  public void sort(boolean isTesting) {
    boolean swapped = true;
    while (swapped) {
      swapped = false;
      for (int i = 0; i < toSolve.size() - 1; i++) {
        high = i + 1;
        low = i;
        repaintAndSleepMillis(isTesting, delay);
        if (interrupted) {
          return;
        }
        if (toSolve.get(i) > toSolve.get(i + 1)) {
          swap(i, i + 1);
          repaintAndSleepMillis(isTesting, delay);
          if (interrupted) {
            return;
          }
          swapped = true;
        }
      }

      if (!swapped) {
        break;
      }

      swapped = false;
      for (int i = toSolve.size() - 2; i >= 0; i--) {
        high = i + 1;
        low = i;
        repaintAndSleepMillis(isTesting, delay);
        if (interrupted) {
          return;
        }
        if (toSolve.get(i) > toSolve.get(i + 1)) {
          swap(i, i + 1);
          repaintAndSleepMillis(isTesting, delay);
          if (interrupted) {
            return;
          }
          swapped = true;
        }
      }
    }
  }

  /**
   * Create a new CocktailShakerSort with the given number of elements.
   * @param size The number of elements to sort
   * @return The newly created CocktailShakerSort
   */
  @Override
  public SorterBase newRandom(int size) {
    return new CocktailShakerSort(size);
  }
}
