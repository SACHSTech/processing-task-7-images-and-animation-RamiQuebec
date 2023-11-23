import processing.core.PApplet;

/**
 * Main class to execute sketch
 * @author Rami Kabak
 * A Java PApplet sketch for image animation, includes a retro background, 
 * a Screesaver DVD animated with edge detection,
 * a circle shape with linear movement from left to right
 * and a floppy disk with circular movement using cosine, sine and the millis function().
 */
class Main {
  public static void main(String[] args) {
    
    String[] processingArgs = {"MySketch"};
	  Sketch mySketch = new Sketch();
	  PApplet.runSketch(processingArgs, mySketch);
  }
  
}