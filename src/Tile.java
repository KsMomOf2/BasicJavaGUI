import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Point;

public class Tile {
private final String filename = "HackBI.png";
private Image tile;
private Point point;

Tile(int x, int y) {

//tile = ImageIO.read(filename);
point = new Point(x, y);

}

public void draw(Graphics g) {
  g.drawImage(tile, (int) point.getX(), (int) point.getY(), null);
}
public void move(int dx, int dy) {
  point.translate(dx, dy);
 } 
}