import processing.core.PApplet;

public class GrowAndShrink implements Particle {
    private final PApplet p5;
    private float size;
    private float x;
    private float y;
    private int myColour;
    private int growthRate = 5;

    public GrowAndShrink(PApplet p5, float x, float y, float size) {
        this.p5 = p5;
        this.x = x;
        this.y = y;
        this.size = size;
        this.myColour = p5.color(0, p5.random(0, 255), 0);
    }
    @Override
    public void display() {
        p5.fill(myColour);
        p5.circle(x, y, size);
    }

    @Override
    public void update() {
        if(size > 50) {
            growthRate = -1;
        }
        if(size < 10) {
            growthRate = 1;
        }
        size += growthRate;
    }
}
