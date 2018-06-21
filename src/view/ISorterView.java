package view;

import java.awt.event.ActionListener;

import sorters.SorterBase;

// Represents a view of a sorting algorithm running
public interface ISorterView {
  /**
   * Display the given sorting algorithm.
   * @param base The algorithm to draw
   */
  void display(SorterBase base);

  /**
   * Add a button to the window with the given name, position, and listener.
   * @param name The name of the button
   * @param listener The ActionListener associated with the button
   * @param position The position of the button in the window
   */
  void addButton(String name, ActionListener listener, String position);

  /**
   * Close the sorting algorithm window.
   */
  void close();
}
