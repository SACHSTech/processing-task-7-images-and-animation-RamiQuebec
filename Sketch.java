import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  // Variable setup
  PImage retroBackground;
  PImage movingDVD;
  PImage floppyDisk;

  float fltDVDX = 0;
  float fltDVDY = 0;

  float fltSpeedDVDX = 3;
  float fltSpeedDVDY = 3;

  int widthDVD;
  int heightDVD;

  // Called once at the beginning of execution, put your size all in this method
  public void settings() {
    // Screen size
    size(1600, 900);
  }

  // Called once at the beginning of execution. Add initial set up values here i.e background, stroke, fill etc.
  public void setup() {
    // Black background
    background(0, 0, 0);
    
    // Retro Background
    retroBackground = loadImage("Retro.jpg");

    // Screensaver DVD with movement and edge detection
    movingDVD = loadImage("DVD.png");
    
    // Circular (Non-linear) Movement Floppy Disk
    floppyDisk = loadImage("FloppyDisk.png");

    // DVD size and randomizing starting position
    widthDVD = movingDVD.width / 8;
    heightDVD = movingDVD.height / 8;
    movingDVD.resize(widthDVD, heightDVD);
    fltDVDX = random(width - widthDVD); 
    fltDVDY = random(height - heightDVD);

    // Floppy Disk size
    floppyDisk.resize(50, 50);
  }

  // Called repeatedly, anything drawn to the screen goes here
  public void draw() {
    // Draw Retro background and DVD
    image(retroBackground, 0, 0);
    image(movingDVD, fltDVDX, fltDVDY);

    // Animate DVD diagonally
    fltDVDX += fltSpeedDVDX;
    fltDVDY += fltSpeedDVDY;

    // If statement for edge detection
    if (fltDVDX <= 0 || fltDVDX + widthDVD >= width) {
        fltSpeedDVDX *= -1;
    }
    if (fltDVDY <= 0 || fltDVDY + heightDVD >= height) {
        fltSpeedDVDY *= -1;
    }
    
    /**
    * Make CircleX variable with X and Cosine with millis()
    * (returns milliseconds) function to produce linear movement
    */
    float circleX = 800 + cos(millis() * 0.005f) * 75;
    ellipse(circleX, 175, 20, 20);

    /**
    * Make Floppy Disk X & Y variable with x, y and Sine + Cosine with millis()
    * (returns milliseconds) function to produce circular movement
    */
    float floppyDiskX = 800 + cos(millis() * 0.02f) * 50;
    float floppyDiskY = 800 + sin(millis() * 0.02f) * 50;

    // Draw Floppy Disk
    image(floppyDisk, floppyDiskX, floppyDiskY);
  }
}
