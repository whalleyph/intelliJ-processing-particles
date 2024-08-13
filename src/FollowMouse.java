import processing.core.PApplet;

public class FollowMouse implements Particle {
    private final PApplet p5;
    private float size;
    private float x;
    private float y;
    private int myColour;
    private float xVel = 0;
    private float yVel = 0;

    public FollowMouse(PApplet p5, float x, float y, float size) {
        this.p5 = p5;
        this.x = x;
        this.y = y;
        this.size = size;
        this.myColour = p5.color(p5.random(0, 255), 0, 0);
    }

    @Override
    public void display() {
        p5.fill(myColour);
        p5.circle(x, y, size);
    }

    @Override
    public void update() {
        final float stepSize = 0.01F;
        if(x < p5.mouseX) {
            xVel += stepSize;
        } else if (x > p5.mouseX) {
            xVel -= stepSize;
        }

        if(y < p5.mouseY) {
            yVel += stepSize;
        } else if (y > p5.mouseY) {
            yVel -= stepSize;
        }
        x += xVel;
        y += yVel;
    }
}
