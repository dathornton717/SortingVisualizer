package view;

import java.awt.event.ActionListener;

// Represents a menu view.
public interface IMenuView {
  /**
   * Display the menu.
   */
  void display();

  /**
   * Add a button to the menu with the given name and ActionListener.
   * @param name The name of the button
   * @param listener The ActionListener associated with the button
   */
  void addButton(String name, ActionListener listener);

  /**
   * Close the menu window.
   */
  void close();
}
