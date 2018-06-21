package sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CocktailShakerSortTest {
  @Test
  public void testCocktailShakerSort() {
    for (int i = 0; i < 5; i++) {
      CocktailShakerSort cocktailShakerSort = new CocktailShakerSort();
      cocktailShakerSort.sort(true);

      List<Integer> solved = cocktailShakerSort.getToSolve();
      for (int j = 0; j < solved.size() - 1; j++) {
        Assert.assertTrue(solved.get(j) < solved.get(j + 1));
      }
    }
  }
}