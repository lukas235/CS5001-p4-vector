package shapes;

import java.awt.geom.Ellipse2D;

import gui.Config;

public class XCircle extends XEllipse {

 @Override
 public void draw(int x1, int y1, int x2, int y2) {

  int s = Math.min(Math.abs(x2 - x1), Math.abs(y2 - y1));

  int x = x1 > x2 ? x1 - s : x1;
  int y = y1 > y2 ? y1 - s : y1;

  super.draw(x, y, x + s, y + s);

 }
 
 @Override
 public void resize(int x, int y, int corner) {

  int s = 0;

  if (corner == Config.HIT_BOTTOM_RIGHT) {
   s = Math.min(Math.abs(x - x1), Math.abs(y - y1));
   super.draw(x1, y1, x1 + s, y1 + s);

  }
  else if (corner == Config.HIT_TOP_LEFT) {
   s = Math.min(Math.abs(x - x2), Math.abs(y - y2));
   super.draw(x2 - s, y2 - s, x2, y2);

  }
  else if (corner == Config.HIT_TOP_RIGHT) {
   s = Math.min(Math.abs(x - x1), Math.abs(y - y2));
   super.draw(x1, y2 - s, x1 + s, y2);
  }
  else if (corner == Config.HIT_BOTTOM_LEFT) {
   s = Math.min(Math.abs(x - x2), Math.abs(y - y1));
   super.draw(x2 - s, y1, x2, y1 + s);
  }
 }

}
