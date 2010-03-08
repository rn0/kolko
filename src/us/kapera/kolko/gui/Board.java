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

  public static final int boardSize = 5;

  public Board() {
    setTitle("Kółko i krzyżyk");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container pane = getContentPane();
    pane.setLayout(new GridLayout(0, boardSize));
    figures = new FigureButton[boardSize][boardSize];
    
    for(int i = 0; i < boardSize; i++) {
      for(int j = 0; j < boardSize; j++) {
        figures[i][j] = new FigureButton(i, j);
        figures[i][j].addPropertyChangeListener("text", new PropertyChangeListener() {
          public void propertyChange(PropertyChangeEvent e) {
            FigureButton source = (FigureButton)e.getSource();
            checkWinner(source.getPos_x(), source.getPos_y());
          }
        });
        pane.add(figures[i][j]);
      }
    }
    
    setSize(400, 400);
    setVisible(true);
  }

  private void checkWinner(int x, int y) {
    String state  = figures[x][y].getText();
    boolean row = true, column = true, slash = true, backslash = true;

    for(int i = 0; i < boardSize; i++) {
      // wiersze
      if (row && !figures[x][i].getText().equals(state)) {
        row = false;
      }

      // kolumny
      if (column && !figures[i][y].getText().equals(state)) {
        column = false;
      }

      // przekatne
      if (slash && !figures[i][i].getText().equals(state)) {
        slash = false;
      }
      if (backslash && !figures[i][boardSize - i - 1].getText().equals(state)) {
        backslash = false;
      }
    }

    if(row || column || slash || backslash) {
      String mark = "";
      if(row) {
        mark = "wiersz";
      }
      if(column) {
        mark = "kolumna";
      }
      if(slash) {
        mark = "slash";
      }
      if(backslash) {
        mark = "backslash";
      }
      System.out.println("winner: " + state + " -> " + mark);
    }
  }
}
