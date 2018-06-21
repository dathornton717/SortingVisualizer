package sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import sorters.BubbleSort;

public class BubbleSortTest {
  @Test
  public void testBubbleSort() {
    for (int i = 0; i < 5; i++) {
      BubbleSort bubbleSort = new BubbleSort();
      bubbleSort.sort(true);

      List<Integer> solved = bubbleSort.getToSolve();
      for (int j = 0; j < solved.size() - 1; j++) {
        Assert.assertTrue(solved.get(j) < solved.get(j + 1));
      }
    }
  }
}