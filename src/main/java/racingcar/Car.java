package racingcar;

import java.util.Random;

public class Car {
    private static final Integer MAX_NUMBER = 10;
    public static final Integer MINIMUM_NUMBER_TO_MOVE = 6;
    private static final String ONE_POSITION_MARK = "-";
    private static final Random RANDOM = new Random();

    public Integer position = 0;

    public void moveAndPrint() {
        if (isMovable(randomNumber())) {
            move();
        }
        printPosition();
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

    private void printPosition() {
        System.out.println(ONE_POSITION_MARK.repeat(this.position));
    }
}
