package sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ShellSortTest {
  @Test
  public void testShellSort() {
    for (int i = 0; i < 5; i++) {
      ShellSort shellSort = new ShellSort();
      shellSort.sort(true);

      List<Integer> solved = shellSort.getToSolve();
      for (int j = 0; j < solved.size() - 1; j++) {
        Assert.assertTrue(solved.get(j) < solved.get(j + 1));
      }
    }
  }
}