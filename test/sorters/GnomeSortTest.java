package sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GnomeSortTest {
  @Test
  public void testGnomeSort() {
    for (int i = 0; i < 5; i++) {
      GnomeSort gnomeSort = new GnomeSort();
      gnomeSort.sort(true);

      List<Integer> solved = gnomeSort.getToSolve();
      for (int j = 0; j < solved.size() - 1; j++) {
        Assert.assertTrue(solved.get(j) < solved.get(j + 1));
      }
    }
  }
}