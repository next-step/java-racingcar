package CarRacing;

import java.util.Random;

public class Position {

    private int position = 0;
    private Random random = new Random();


    public void move() {
        if (random.nextInt(10) > 3) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
