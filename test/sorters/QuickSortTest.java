package sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import sorters.QuickSort;

public class QuickSortTest {
  @Test
  public void testQuickSort() {
    for (int i = 0; i < 5; i++) {
      QuickSort quickSort = new QuickSort();
      quickSort.sort(true);

      List<Integer> solved = quickSort.getToSolve();
      for (int j = 0; j < solved.size() - 1; j++) {
        Assert.assertTrue(solved.get(j) < solved.get(j + 1));
      }
    }
  }
}