package sorters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import controller.Controller;

// Class for all Sorting bases
public abstract class SorterBase extends JPanel {
  List<Integer> original;
  List<Integer> toSolve;
  int low;
  int high;
  int delay;
  String title;
  boolean interrupted;
  int size;

  public SorterBase() {
    this(100);
  }

  public SorterBase(int size) {
    this.size = size;
    this.original = new ArrayList<Integer>();
    this.low = -1;
    this.high = -1;

    for (int i = 0; i < size; i++) {
      this.original.add(i + 1);
    }

    Collections.shuffle(this.original);
    this.toSolve = new ArrayList<Integer>(this.original);
    this.delay = 50;
    this.interrupted = false;
  }

  public SorterBase(SorterBase base) {
    this.original = base.original;
    this.toSolve = new ArrayList<Integer>(this.original);
    this.delay = 50;
    this.interrupted = false;
  }

  /**
   * Sort the list of numbers.
   * @param isTesting Whether tests are being run or not
   */
  public abstract void sort(boolean isTesting);

  /**
   * Create a new sorting algorithm with the given number of elements.
   * @param size The number of elements to sort
   * @return The newly created sorting algorithm
   */
  public abstract SorterBase newRandom(int size);

  /**
   * Swap the elements at the given indices.
   * @param i The first element to swap
   * @param j The second element to swap
   */
  public void swap(int i, int j) {
    Integer tmp = toSolve.get(i);
    toSolve.set(i, toSolve.get(j));
    toSolve.set(j, tmp);
  }

  /**
   * Get the original list of numbers to be sorted.
   * @retuen The original list of numbers
   */
  public List<Integer> getOriginal() {
    return new ArrayList<Integer>(original);
  }

  /**
   * Get the list of numbers to be sorted.
   * @return The list of numbers to be sorted
   */
  public List<Integer> getToSolve() {
    return new ArrayList<Integer>(toSolve);
  }

  /**
   * Get the title of the sorting algorithm.
   * @return The title of the algorithm
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Get the delay between graphic draws.
   * @return The delay between draws in milliseconds or nanoseconds
   */
  public int getDelay() {
    return delay;
  }

  /**
   * Set the delay to the given int.
   * @param delay The delay
   */
  public void setDelay(int delay) {
    this.delay = delay;
  }

  /**
   * Has the sorting algorithm been interrupted?
   * @return Whether the sorting algorithm has been interrupted
   */
  public boolean isInterrupted() {
    return interrupted;
  }

  /**
   * Set whether the sorting algorithm has been interrupted.
   * @param interrupted The boolean to set
   */
  public void setInterrupted(boolean interrupted) {
    this.interrupted = interrupted;
  }

  /**
   * Get the number of elements being sorted.
   * @return The number of elements in the toSort list
   */
  public int getArraySize() {
    return size;
  }

  /**
   * Set the number of elements to be sorted.
   * @param size The number of elements to be sorted
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Repaint the algorithm and then sleep the given number of milliseconds.
   * @param isTesting Whether tests are being run
   * @param amount The number of milliseconds to sleep
   */
  public void repaintAndSleepMillis(boolean isTesting, long amount) {
    if (isTesting) {
      return;
    }

    this.repaint();
    try {
      Thread.sleep(amount);
    } catch (InterruptedException e) {
      this.interrupted = true;
    }
  }

  /**
   * Repaint the algorithm and then sleep the given number of nanoseconds.
   * @param isTesting Whether tests are being run
   * @param amount The number of nanoseconds to sleep
   */
  public void repaintAndSleepNano(boolean isTesting, int amount) {
    if (isTesting) {
      return;
    }

    this.repaint();
    try {
      Thread.sleep(0, amount);
    } catch (InterruptedException e) {
      this.interrupted = true;
    }
  }

  /**
   * Reset the sorting algorithm.
   */
  public void reset() {
    low = -1;
    high = -1;
    toSolve = new ArrayList<Integer>(original);
    this.interrupted = false;
  }

  /**
   * Get the preferred size of the window of the algorithm.
   * @return The dimensions of the window
   */
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(Controller.WIDTH, Controller.HEIGHT);
  }

  /**
   * Paint the sorting algorithm.
   * @param g The Graphics to use to draw
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int i = 0; i < toSolve.size(); i++) {
      Integer element = toSolve.get(i);

      if (i == this.low) {
        g.setColor(Color.red);
      }
      else if (i == this.high) {
        g.setColor(Color.GREEN);
      }
      else {
        g.setColor(new Color(204, 204, 255));
      }

      int proportionHeight = (int)(element * (Controller.HEIGHT / (double)size));

      g.fillRect(i * (Controller.WIDTH / size), Controller.HEIGHT - proportionHeight,
              Controller.WIDTH / size, proportionHeight);

      g.setColor(Color.BLACK);
      g.drawRect(i * (Controller.WIDTH / size), Controller.HEIGHT - proportionHeight,
              Controller.WIDTH / size, proportionHeight);
    }
  }
}
