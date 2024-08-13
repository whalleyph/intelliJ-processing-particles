import processing.core.PApplet;


public class Main extends PApplet {
    Particle[] particles;

    public static void main(String[] args) {
        PApplet.main(new String[]{"Main"});
    }

    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        particles = createParticles(this, 10);
    }

    public static Particle[] createParticles(PApplet p5, int numToCreate) {
        Particle[] particles = new Particle[numToCreate];
        for (int i = 0; i < numToCreate; i++) {
            particles[i] = createRandomParticles(p5);
        }
        return particles;
    }

    private static Particle createRandomParticles(PApplet p5) {
        double randomNumber = Math.random();
        float x = p5.random(0f, 800f);
        float y = p5.random(0f, 600f);
        float size = p5.random(10, 50);
        if (randomNumber > 2 / 3F) {
            return new RandomWalker(p5, x, y, size);
        } else if (randomNumber > 1 / 3F) {
            return new FollowMouse(p5, x, y, size);
        }
        return new GrowAndShrink(p5, x, y, size);
    }

    @Override
    public void draw() {
        background(100);
        for (Particle s : particles) {
            s.display();
        }

        for (Particle s : particles) {
            s.update();
        }
    }
}