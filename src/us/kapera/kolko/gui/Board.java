package us.kapera.kolko.gui;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * User: piotr
 * Date: 2010-03-06
 * Time: 23:08:35
 */
public class Board extends JFrame {

  static Boolean state = false;
  private JButton figures[][];

  public Board() {
    setTitle("Kółko i krzyżyk");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container pane = getContentPane();
    pane.setLayout(new GridLayout(0,3));
    figures = new FigureButton[3][3];
    
    for(int i = 0; i < figures.length; i++) {
      for(int j = 0; j < figures[i].length; j++) {
        figures[i][j] = new FigureButton("");
        figures[i][j].addPropertyChangeListener("text", new PropertyChangeListener() {
          public void propertyChange(PropertyChangeEvent e) {
            checkWinner();
          }
        });
        pane.add(figures[i][j]);
      }
    }
    
    setSize(400, 400);
    setVisible(true);
  }

  private void checkWinner() {
    System.out.print("checkWinner -> ");
    for(int i = 0; i < figures.length; i++) {
      for(int j = 0; j < figures[i].length; j++) {
        String state = figures[i][j].getText();
        System.out.printf("[%d-%d]:%s ", i, j, (state.isEmpty() ? "-" : state));
      }
    }
    System.out.print("\n");
  }
}
