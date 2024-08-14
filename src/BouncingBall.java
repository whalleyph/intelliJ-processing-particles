import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class BouncingBall implements Particle {
    private final PApplet p5;
    private float size;
    PVector pos;
    PVector vel;
    PVector accel;
    private final int myColour;
    private PImage shipImage;

    public BouncingBall(PApplet p5, float x, float y, float size) {
        this.p5 = p5;
        this.pos = new PVector(x, y);
        this.vel = new PVector(0, 1);
        this.accel = new PVector(0, 1);
        this.size = size;
        this.myColour = p5.color(255, 255, 0);
        // inefficient every ball loads the same image from disc
        shipImage = p5.loadImage("images/playerShip1_blue.png");
    }

    @Override
    public void display() {
        p5.push();
        p5.fill(myColour);
        p5.translate(pos.x, pos.y);
        p5.rotate(vel.heading() + PApplet.PI/2);
        p5.scale(0.5F);
        p5.rectMode(PApplet.CENTER);
        p5.imageMode(PApplet.CENTER);
        p5.square(0, 0, size);
        p5.image(shipImage, 0, 0);
        p5.pop();
    }

    @Override
    public void update() {
        pos.add(vel);
//        vel.add(accel);
        accelTowardsMouse();
        bounce();
        vel.limit(6);
    }

    private void accelTowardsMouse() {
//        find vector from ball to mousePos
        var mousePos = new PVector(p5.mouseX, p5.mouseY);
        var delta = PVector.sub(mousePos, pos);
        PVector force = delta.setMag(0.5F);
        vel.add(force);
    }


    public void bounce() {
        if (pos.y >= p5.height) {
            pos.y = p5.height;
            vel.y = vel.y * -1;
        }

        if (pos.y <= 0) {
            pos.y = 0;
            vel.y = vel.y * -1;
        }

        if (pos.x >= p5.width) {
            pos.x = p5.width;
            vel.x = vel.x * -1;
        }

        if (pos.x <= 0) {
            pos.x = 0;
            vel.x = vel.x * -1;
        }
    }
}
