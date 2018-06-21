package sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import sorters.StoogeSort;


public class StoogeSortTest {
  @Test
  public void testStoogeSort() {
    for (int i = 0; i < 5; i++) {
      StoogeSort stoogeSort = new StoogeSort();
      stoogeSort.sort(true);

      List<Integer> solved = stoogeSort.getToSolve();
      for (int j = 0; j < solved.size() - 1; j++) {
        Assert.assertTrue(solved.get(j) < solved.get(j + 1));
      }
    }
  }
}