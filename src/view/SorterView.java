package view;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import sorters.SorterBase;

// Represents a view of a sorting algorithm
public class SorterView implements ISorterView {
  private JPanel panel;
  private JFrame frame;
  private JPanel buttonPanel;
  private JLabel label;

  public SorterView() {
    label = new JLabel();
    JFrame.setDefaultLookAndFeelDecorated(true);
    this.frame = new JFrame("Sorting Visualizer");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    this.panel = new JPanel(new BorderLayout());

    buttonPanel = new JPanel();

    BoxLayout boxLayout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);

    buttonPanel.setLayout(boxLayout);

    buttonPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
  }

  /**
   * Display the given sorting algorithm.
   * @param base The algorithm to draw
   */
  @Override
  public void display(SorterBase base) {
    if (panel.getComponents().length > 0) {
      panel.remove(label);
    }

    label.setText(base.getTitle());
    label.setHorizontalAlignment(JLabel.CENTER);
    panel.add(label, BorderLayout.NORTH);
    panel.add(base, BorderLayout.CENTER);

    frame.add(panel, BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Add a button to the sorting algorithm window.
   * @param name The name of the button
   * @param listener The ActionListener associated with the button
   * @param position The position of the button in the window
   */
  @Override
  public void addButton(String name, ActionListener listener, String position) {
    JButton button = new JButton(name);
    button.addActionListener(listener);
    buttonPanel.add(button);
  }

  /**
   * Close the sorting algorithm window.
   */
  @Override
  public void close() {
    frame.setVisible(false);
  }
}
