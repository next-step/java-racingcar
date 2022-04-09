package racing;

import java.util.Random;

public class Car {
    private static final Random RANDOM = new Random();
    public static final int STOP = 0;
    public static final int MOVE_FORWARD = 1;

    private String name;
    private int distance;

    public Car() {
        this("", 0);
    }

    private Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void accumulateOneLap() {
        int randomNumber = RANDOM.nextInt(10);
        distance += moveForwardOrStop(randomNumber);
    }

    public int moveForwardOrStop(int randomNumber) {
        if (randomNumber < 4) {
            return STOP;
        }

        return MOVE_FORWARD;
    }

    public void printCarStatus() {
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
    }
}
