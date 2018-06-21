package sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HeapSortTest {
  @Test
  public void testHeapSort() {
    for (int i = 0; i < 5; i++) {
      HeapSort heapSort = new HeapSort();
      heapSort.sort(true);

      List<Integer> solved = heapSort.getToSolve();
      for (int j = 0; j < solved.size() - 1; j++) {
        Assert.assertTrue(solved.get(j) < solved.get(j + 1));
      }
    }
  }
}