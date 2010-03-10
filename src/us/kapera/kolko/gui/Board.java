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
  private FigureButton figures[][];

  public static final int boardSize = 5;
  private int moveNo = 0;

  public Board() {
    setTitle("Kółko i krzyżyk");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container pane = getContentPane();
    pane.setLayout(new GridLayout(0, boardSize));
    figures = new FigureButton[boardSize][boardSize];
    
    for(int i = 0; i < boardSize; i++) {
      for(int j = 0; j < boardSize; j++) {
        figures[i][j] = new FigureButton(i, j);
        figures[i][j].addPropertyChangeListener("move", new PropertyChangeListener() {
          public void propertyChange(PropertyChangeEvent e) {
            moveNo++;

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

    // TODO: refactor
    if(row || column || slash || backslash) {
      if(row) {
        for(int i = 0; i < boardSize; i++) {
          figures[x][i].mark();
        }
      }
      if(column) {
        for(int i = 0; i < boardSize; i++) {
          figures[i][y].mark();
        }
      }
      if(slash) {
        for(int i = 0; i < boardSize; i++) {
          figures[i][i].mark();
        }
      }
      if(backslash) {
        for(int i = 0; i < boardSize; i++) {
          figures[i][boardSize - i - 1].mark();
        }
      }
      System.out.println("winner: " + state);
      JOptionPane.showMessageDialog(null, "winner: " + state);
      resetBoard();
    }

    if(moveNo == boardSize * boardSize) {
      JOptionPane.showMessageDialog(null, "remis");
      resetBoard();
    }
  }

  private void resetBoard() {
    state = false;
    moveNo = 0;
    
    for(int i = 0; i < boardSize; i++) {
      for(int j = 0; j < boardSize; j++) {
        figures[i][j].reset();
      }
    }
  }
}
