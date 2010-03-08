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
  private int pos_x;
  private int pos_y;

  public FigureButton(int pos_x, int pos_y) {
    super("");

    setPos_x(pos_x);
    setPos_y(pos_y);

    setBorder(new LineBorder(Color.BLACK, 1));
    setBackground(Color.WHITE);
    setFont(new Font(null, Font.BOLD, 50));
    addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    System.out.printf("click! [%d, %d]\n", getPos_x(), getPos_y());

    setText(Board.state ? "o" : "x");
    Board.state = !Board.state;

    setEnabled(false);
  }

  public int getPos_x() {
    return pos_x;
  }

  public void setPos_x(int pos_x) {
    this.pos_x = pos_x;
  }

  public int getPos_y() {
    return pos_y;
  }

  public void setPos_y(int pos_y) {
    this.pos_y = pos_y;
  }
}
