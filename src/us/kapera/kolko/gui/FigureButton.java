package us.kapera.kolko.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: piotr
 * Date: 2010-03-06
 * Time: 23:33:19
 */
public class FigureButton extends JButton implements ActionListener{
  public FigureButton(String text) {
    super(text);

    setBorder(new LineBorder(Color.BLACK, 1));
    setBackground(Color.WHITE);
    setFont(new Font(null, Font.BOLD, 50));
    addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    setText(Board.state ? "o" : "x");
    Board.state = !Board.state;
    Board.moves++;

    System.out.println("click! move no. " + Board.moves);

    setEnabled(false);
  }
}
