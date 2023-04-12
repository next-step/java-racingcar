package racingcar;

public class Car {
    private static final Integer MINIMUM_NUMBER_TO_MOVE = 4;

    private final Output output;

    public Car(Output output) {
        this.output = output;
    }

    private Integer position = 0;

    public void moveAndPrint(Integer integer) {
        move(integer);
        this.output.printPosition(this.position);
    }

    private void move(Integer number) {
        if (isMovable(number)) {
            this.position++;
        }
    }

    private static boolean isMovable(Integer number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }
}
