package sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import sorters.SelectionSort;

public class SelectionSortTest {
  @Test
  public void testSelectionSort() {
    for (int i = 0; i < 5; i++) {
      SelectionSort selectionSort = new SelectionSort();
      selectionSort.sort(true);

      List<Integer> solved = selectionSort.getToSolve();
      for (int j = 0; j < solved.size() - 1; j++) {
        Assert.assertTrue(solved.get(j) < solved.get(j + 1));
      }
    }
  }
}