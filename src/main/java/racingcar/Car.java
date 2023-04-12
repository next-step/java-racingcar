package racingcar;

import java.util.Random;

public class Car {
    private static final Integer MAX_NUMBER = 10;
    public static final Integer MINIMUM_NUMBER_TO_MOVE = 6;
    private static final Random RANDOM = new Random();
    private final Output output;

    public Car(Output output) {
        this.output = output;
    }

    public Integer position = 0;

    public void moveAndPrint() {
        if (isMovable(randomNumber())) {
            move();
        }
        this.output.printPosition(this.position);
    }

    public void move() {
        this.position++;
    }

    public static boolean isMovable(Integer number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }

    private static Integer randomNumber() {
        return RANDOM.nextInt(MAX_NUMBER);
    }
}
