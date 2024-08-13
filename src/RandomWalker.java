import processing.core.PApplet;

public class RandomWalker implements Particle {
        private final PApplet p5;
        private float size;
        private float x;
        private float y;

        //there's no real color type, it's just stored as an int
        private int myColour;

        public RandomWalker(PApplet p5, float x, float y, float size) {
            this.p5 = p5;
            this.x = x;
            this.y = y;
            this.size = size;
            this.myColour = p5.color(0, 0, p5.random(0, 255));
        }

        public void display() {
            p5.fill(myColour);
            p5.circle(x, y, size);
        }

        public void update() {
            final int stepSize = 5;
            x += p5.random(-stepSize, stepSize);
            y += p5.random(-stepSize, stepSize);
            size = PApplet.constrain(size + p5.random(-1, 1), 5, 100);
        }
}
