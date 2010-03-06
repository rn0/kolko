package us.kapera.kolko.gui;

import javax.swing.*;
import java.awt.*;

/**
 * User: piotr
 * Date: 2010-03-06
 * Time: 23:08:35
 */
public class Board extends JFrame {

  static Boolean state = false;
  static int moves = 0;

  public Board() {
    setTitle("Kółko i krzyżyk");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container pane = getContentPane();
    pane.setLayout(new GridLayout(0,3));
    JButton buttons[] = new JButton[20];
    for(int i = 0; i <= 8; i++) {
      pane.add(buttons[i] = new FigureButton(""));
    }
    
    setSize(400, 400);
    setVisible(true);
  }
}
