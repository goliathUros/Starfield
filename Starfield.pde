Particle[] test = new Particle[100];

void setup()
{
  background(0);
  size(500,500);
  for (int i = 0; i < test.length; i++)
  {
    test[i] = new NormalParticle();
    test[1] = new OddballParticle();
  }
}

void draw()
{
  background(0);
  for (int i = 0; i < test.length; i++) 
  {
    test[i].move();
    test[i].show();
  }
  test[1].show();
  test[1].move();
}

class NormalParticle implements Particle
{
  double xpos, ypos, speed, angle, partSize;
  color partFill;
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

    while (xpos > width || ypos > height || xpos < 0 || ypos < 0) 
    {
      xpos = width/2.00;
      ypos = height/2.00;
      speed = speed + 0.02;
      if (mousePressed) {
        partSize = partSize - 0.75;
      } else {
        partSize = partSize + 0.75;
      }
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
  color partFill;
  OddballParticle() 
  {
    xpos = width/2.00;
    ypos = height/2.00;
    speed = (Math.random()*3) + 2;
    angle = (Math.random()*2*Math.PI);
    partFill = color(255, 0, 0);
  }

  public void move() 
  {
    xpos = xpos + (speed*Math.cos(angle)-3);
    ypos = ypos + (speed*Math.sin(angle)-3);
  }

  public void show() 
  {
    noStroke();
    fill(partFill);
    ellipse(mouseX, mouseY, 20,20);

    /*ellipse((float)xpos, (float)ypos, 25.0, 25.0);
    if (xpos > 490 || ypos > 490) {
      xpos = xpos - (speed*Math.cos(angle)+3);
      ypos = ypos - (speed*Math.sin(angle)+3);
    }*/
  }
}


