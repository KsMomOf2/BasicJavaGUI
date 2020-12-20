import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {
   private final int TILES = 5;
   private Timer timer;
   
   Tile[] tiles;

   GamePanel() {
      createTimer();
      createTiles();
   }
 
   private void createTimer() {
     timer = new Timer(25, new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
       moveAllTiles();
       repaint();
       }
     }
     );
     } 
     
   private void createTiles () {
      tiles = new Tile[TILES];
      int x = 50;
      int y = 300;
      int distance = (int)(2.5 * Tile.getWidth());
   
      for (int t = 0; t < TILES; t++) {
         tiles[t] = new Tile(x, y);
         x += distance;
      }
   }
  
   public void moveAllTiles() {
    int panelWidth =  getWidth();
    int panelHeight = getHeight();
     int distance = 5;
     for (Tile t : tiles) {
       t.move(distance,0, panelWidth, panelHeight);
     }
     }
     
   @Override
   public void paintComponent(Graphics g) {
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, 1000, 1000);
      for (Tile t : tiles) 
         t.draw(g);
   }
   
   public void start() {
     timer.start();
   }
   
   public void stop() {
     timer.stop();
   }
   
   public void startMove() {
     start();
   }
   
   public void jumpUp() {
     tiles[0].move(0, -25, getWidth(), getHeight());
   }
   
   public void jumpDown() {
     tiles[0].move(0, +25, getWidth(), getHeight());
   }
}

