package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sorters.BogoBogoSort;
import sorters.BogoSort;
import sorters.BubbleSort;
import sorters.CocktailShakerSort;
import sorters.GnomeSort;
import sorters.HeapSort;
import sorters.InsertionSort;
import sorters.QuickSort;
import sorters.RadixSort;
import sorters.SelectionSort;
import sorters.ShellSort;
import sorters.SorterBase;
import sorters.StoogeSort;
import view.IMenuView;
import view.ISorterView;
import view.MainMenu;
import view.SorterView;

// The controller used to control the views and sorting bases
public class Controller {
  public static final int WIDTH = 900;
  public static final int HEIGHT = 600;

  private IMenuView view;
  private ISorterView sorterView;
  private SorterBase base;
  private Thread thread;

  public Controller() {
    addSorterButtons();
    addOptionsButtons();
  }

  /**
   * Run the sorting application.
   */
  public void runApplication() {
    this.view.display();
  }

  // Class to add an element to be sorted
  private class MoreElements implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (!base.isInterrupted()) {
        while (thread.isAlive()) {
          thread.interrupt();
        }
        int size = base.getArraySize();
        base = base.newRandom(Math.min(size + 1, Integer.MAX_VALUE));
        sorterView.display(base);
        runSort();
      }
    }
  }

  // Class to remove an element from the sorted list
  private class LessElements implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (!base.isInterrupted()) {
        while (thread.isAlive()) {
          thread.interrupt();
        }
        int size = base.getArraySize();
        base = base.newRandom(Math.max(size - 1, 1));
        sorterView.display(base);
        runSort();
      }
    }
  }

  // Class to generate a new random list of numbers
  private class NewRandom implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (!base.isInterrupted()) {
        while (thread.isAlive()) {
          thread.interrupt();
        }
        base = base.newRandom(base.getArraySize());
        sorterView.display(base);
        runSort();
      }
    }
  }

  // Class to reset the sorting algorithm with the same numbers
  private class Reset implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (!base.isInterrupted()) {
        while (thread.isAlive()) {
          thread.interrupt();
        }
        base.reset();
        runSort();
      }
    }
  }

  // Class to go back to the main menu
  private class BackToMainMenu implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      thread.interrupt();
      sorterView.close();
      view.display();
    }
  }

  // Class to increase the sorting speed
  private class IncreaseSpeed implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      base.setDelay(Math.max(1, base.getDelay() - 10));
    }
  }

  // Class to decrease the sorting speed
  private class DecreaseSpeed implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      base.setDelay(Math.min(Integer.MAX_VALUE, base.getDelay() + 10));
    }
  }

  // Class to pick BogoBogoSort
  private class BogoBogoSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.close();
      base = new BogoBogoSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick BogoSort
  private class BogoSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.close();
      base = new BogoSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick BubbleSort
  private class BubbleSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.close();
      base = new BubbleSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick CocktailShakerSort
  private class CocktailShakerSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.close();
      base = new CocktailShakerSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick GnomeSort
  private class GnomeSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.close();
      base = new GnomeSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick HeapSort
  private class HeapSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      base = new HeapSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick InsertionSort
  private class InsertionSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      base = new InsertionSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick QuickSort
  private class QuickSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      base = new QuickSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick RadixSort
  private class RadixSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      base = new RadixSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick SelectionSort
  private class SelectionSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      base = new SelectionSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick ShellSort
  private class ShellSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      base = new ShellSort();
      sorterView.display(base);
      runSort();
    }
  }

  // Class to pick StoogeSort
  private class StoogeSortPicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      base = new StoogeSort();
      sorterView.display(base);
      runSort();
    }
  }

  /**
   * Add the sorter buttons to the main menu.
   */
  private void addSorterButtons() {
    view = new MainMenu("Pick a Sorting Algorithm");
    view.addButton("Bogobogo Sort", new BogoBogoSortPicker());
    view.addButton("Bogo Sort", new BogoSortPicker());
    view.addButton("Bubble Sort", new BubbleSortPicker());
    view.addButton("Cocktail Shaker Sort", new CocktailShakerSortPicker());
    view.addButton("Gnome Sort", new GnomeSortPicker());
    view.addButton("Heap Sort", new HeapSortPicker());
    view.addButton("Insertion Sort", new InsertionSortPicker());
    view.addButton("Quick Sort", new QuickSortPicker());
    view.addButton("Radix Sort", new RadixSortPicker());
    view.addButton("Selection Sort", new SelectionSortPicker());
    view.addButton("Shell Sort", new ShellSortPicker());
    view.addButton("Stooge Sort", new StoogeSortPicker());
  }

  /**
   * Add the options buttons to the sorting menu.
   */
  private void addOptionsButtons() {
    sorterView = new SorterView();
    sorterView.addButton("Back to Selection", new BackToMainMenu(), BorderLayout.SOUTH);
    sorterView.addButton("Decrease Speed", new DecreaseSpeed(), BorderLayout.SOUTH);
    sorterView.addButton("Increase Speed", new IncreaseSpeed(), BorderLayout.SOUTH);
    sorterView.addButton("Reset", new Reset(), BorderLayout.SOUTH);
    sorterView.addButton("New List", new NewRandom(), BorderLayout.SOUTH);
    sorterView.addButton("Remove Element", new LessElements(), BorderLayout.SOUTH);
    sorterView.addButton("Add Element", new MoreElements(), BorderLayout.SOUTH);
  }

  /**
   * Run the sort that is set to base.
   */
  private void runSort() {
    thread = new Thread() {
      public void run() {
        base.setInterrupted(false);
        base.sort(false);
      }
    };

    thread.start();
  }
}
