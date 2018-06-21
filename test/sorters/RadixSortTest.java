package sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RadixSortTest {
  @Test
  public void testRadixSort() {
    for (int i = 0; i < 5; i++) {
      RadixSort radixSort = new RadixSort();
      radixSort.sort(true);

      List<Integer> solved = radixSort.getToSolve();
      for (int j = 0; j < solved.size() - 1; j++) {
        Assert.assertTrue(solved.get(j) < solved.get(j + 1));
      }
    }
  }
}