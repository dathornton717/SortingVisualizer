package sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import sorters.InsertionSort;

public class InsertionSortTest {

  @Test
  public void testInsertionSort() {
    for (int i = 0; i < 5; i++) {
      InsertionSort insertionSort = new InsertionSort();
      insertionSort.sort(true);

      List<Integer> solved = insertionSort.getToSolve();
      for (int j = 0; j < solved.size() - 1; j++) {
        Assert.assertTrue(solved.get(j) < solved.get(j + 1));
      }
    }
  }
}