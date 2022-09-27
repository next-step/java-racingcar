package step3;

import java.util.Random;

public class Car {
    private int id;
    private int position = 1;

    private static final Random random = new Random();
    private static final int RANGE_TO_RANDOM_NUMBER = 10;
    private static final int LIMIT_POINT_TO_MOVE = 4;

    Car(int id) {
        this.id = id;
    }

    public void run() {
        if (isMovable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    private boolean isMovable() {
        return generateRandomPoint() >= LIMIT_POINT_TO_MOVE ;
    }

    private static int generateRandomPoint(){
        return random.nextInt(RANGE_TO_RANDOM_NUMBER);
    }

}
