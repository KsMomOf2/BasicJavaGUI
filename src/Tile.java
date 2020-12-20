import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

public class Tile {
   private final String filename = "HackBI_50.png";
   private Image tile;
   private Point point;
   public static int width = 50;
   public static int height = 50;
   Tile() {
      this(0, 0);
   }

   Tile(int x, int y) {
      try {
         tile = ImageIO.read(new File(filename));
      } catch (IOException e) {
         System.out.println("Image Not Found");
         tile = null;
      }
      point = new Point(x, y);
   
   }

   public void draw(Graphics g) {
      g.drawImage(tile, (int) point.getX(), (int) point.getY(), null);
   }
    
   public void move(int dx, int dy, int panelWidth, int panelHeight) {
      point.translate(dx, dy);
      int x = (int) point.getX();
      int y = (int) point.getY();
      if (x > panelWidth) {
         point.move(0, y);
         x = 0;
      }
      if (x < 0) { 
         x = panelWidth - getWidth();
         point.move(x, y);
      }
      if (y < 0) {
      System.out.printf("y: %d, panelHeight: %d, height: %d\n", y, panelHeight, getHeight());
         y = panelHeight - getHeight();
         point.move(x, y);
      }
      
      if (y > panelHeight) {
      System.out.printf("y: %d, panelHeight: %d\n", y, panelHeight);
         y = 0;
         point.move(x, 0);  
      }
      
   } 

   public static int getWidth() {
      return width;
   }
   public static int getHeight() {
      return height;
   }
}