package shapes;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public abstract class XShape implements Serializable {

 protected Shape shape;
 private Color color;
 private boolean fill;
 private int line = 1;
 
 protected int x1=0;
 protected int y1=0;
 protected int x2=0;
 protected int y2=0;
 protected int width=0;
 protected int height=0;

// public Rectangle2D.Double[] getSelections() {
//  Rectangle2D.Double[] selections = new Rectangle2D.Double[4];
//  if (shape != null && !shape.equals(null)) {
//   selections[0] = new Rectangle2D.Double(shape.getBounds().getMinX() - 3, shape.getBounds().getMinY() - 3, 6, 6);
//   selections[1] = new Rectangle2D.Double(shape.getBounds().getMaxX() - 3, shape.getBounds().getMinY() - 3, 6, 6);
//   selections[2] = new Rectangle2D.Double(shape.getBounds().getMinX() - 3, shape.getBounds().getMaxY() - 3, 6, 6);
//   selections[3] = new Rectangle2D.Double(shape.getBounds().getMaxX() - 3, shape.getBounds().getMaxY() - 3, 6, 6);
//
//   return selections;
//  }
//
//  else {
//   return null;
//  }
//
// }

// public Rectangle2D.Double[] deselect() {
//  return new Rectangle2D.Double[4];
// }

 public boolean isClicked(int x, int y) {
  if (shape.contains(x, y)) {
   return true;
  }
  else {
   return false;
  }
 }

 public abstract void draw(int x1, int y1, int x2, int y2);

 public abstract void dragTo(int x, int y);

 public abstract void resize(int x, int y, int corner);
 
 public abstract void changeOrientation();
 
 public void updateBounds(){
  this.x1=(int) shape.getBounds().getMinX();
  System.out.println("minX: "+x1);
  this.y1=(int) shape.getBounds().getMinY();
  System.out.println("minY: "+y1);
  this.x2=(int) shape.getBounds().getMaxX();
  System.out.println("maxX: "+x2);
  this.y2=(int) shape.getBounds().getMaxY();
  System.out.println("maxY: "+y2);
 }

 public Shape getShape() {
  return shape;
 }

 public void setShape(Shape shape) {
  this.shape = shape;
 }

 public Color getColor() {
  return color;
 }

 public void setColor(Color color) {
  this.color = color;
 }

 public boolean isFill() {
  return fill;
 }

 public void setFill(boolean fill) {
  this.fill = fill;
 }

 public int getLine() {
  return line;
 }

 public void setLine(int line) {
  this.line = line;
 }
 
// public String toString() {
//  return "XShape [shape=" + shape.toString() + ", color=" + color.toString() + "]";
// }

}
