package view;

import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

// Class to represent the main menu
public class MainMenu implements IMenuView {
  private JPanel panel;
  private JFrame frame;
  private JLabel title;

  public MainMenu(String title) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    this.frame = new JFrame("Sorting Visualizer Main Menu");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.panel = new JPanel();
    this.title = new JLabel(title);
    this.panel.add(this.title);
  }

  /**
   * Display the main menu.
   */
  @Override
  public void display() {
    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

    panel.setLayout(boxLayout);

    panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Add a button to the main menu.
   * @param name The name of the button
   * @param listener The ActionListener associated with the button
   */
  @Override
  public void addButton(String name, ActionListener listener) {
    JButton button = new JButton(name);
    button.addActionListener(listener);
    panel.add(button);
  }

  /**
   * Close the main menu.
   */
  @Override
  public void close() {
    frame.setVisible(false);
  }
}
