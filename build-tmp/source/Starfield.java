import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle[] test = new Particle[100];

public void setup()
{
  background(0);
  size(400,400);
  for (int i = 0; i < test.length; i++)
  {
    test[i] = new NormalParticle();
    test[1] = new OddballParticle();
  }
}

public void draw()
{
  background(0);
  for (int i = 0; i < test.length; i++) 
  {
    test[i].move();
    test[i].show();
  }
}

class NormalParticle implements Particle
{
  double xpos, ypos, speed, angle, partSize;
  int partFill;
  NormalParticle() 
  {
    xpos = width/2;
    ypos = height/2;
    speed = (Math.random()*7) + 2;
    angle = Math.random()*2*Math.PI;
    partFill = color (0, 150, (int) (Math.random()*255));
    partSize = 10;
  }

  public void move() 
  {
    xpos = xpos + (speed*Math.cos(angle));
    ypos = ypos + (speed*Math.sin(angle));
  }

  public void show() 
  {
    noStroke();
    fill(partFill);
    ellipse((float)xpos, (float)ypos, (float)partSize, (float)partSize);

    if (xpos > width || ypos > height || xpos < 0 || ypos < 0) 
    {
      xpos = width/2;
      ypos = height/2;
      speed = speed + 0.02f;
      partSize = partSize - 1;
    }
  }
}

interface Particle
{
  public void move();
  public void show();
}

class OddballParticle implements Particle
{
  double xpos, ypos, speed, angle;
  int partFill;
  OddballParticle() 
  {
    xpos = width/2;
    ypos = height/2;
    speed = (Math.random()*3) + 2;
    angle = (Math.random()*2*Math.PI);
    partFill = color(255, 0, 0);
  }

  public void move() 
  {
    xpos = xpos++;
    ypos = ypos++;

    //xpos = xpos + (speed*Math.cos(angle)-4);
    //ypos = ypos + (speed*Math.sin(angle)-4);
  }

  public void show() 
  {
    noStroke();
    fill(partFill);
    ellipse(200, 200, 20,20);

    /*if (xpos > width - 10 || ypos > height - 10)
    {
      xpos = xpos - (speed*Math.cos(angle)-4);
      ypos = ypos - (speed*Math.sin(angle)-4);
    } 
    else if (xpos < 0 || ypos < 0)
    {
      xpos = xpos + (speed*Math.cos(angle)-4);
      ypos = ypos + (speed*Math.sin(angle)-4);
    }*/
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
