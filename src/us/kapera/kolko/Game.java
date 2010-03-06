package us.kapera.kolko;

/**
 * User: piotr
 * Date: 2010-03-06
 * Time: 21:13:38
 */
public class Game {
  public static void main(String[] arg) {
    System.out.print("Hello");

    Board dialog = new Board();
    dialog.pack();
    dialog.setVisible(true);
    System.exit(0);
  }
}
