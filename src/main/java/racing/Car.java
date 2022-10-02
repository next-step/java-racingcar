package racing;

import java.util.Random;

public class Car {
    private static final Random random = new Random();
    private Engine engine = new BasicEngine();
    private int position = 0;

    public int move() {
        if (engine.canMove(random.nextInt(9))) {
            ++position;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

}
