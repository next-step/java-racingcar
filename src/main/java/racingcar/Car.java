package racingcar;

public class Car {
    private static final Integer MINIMUM_NUMBER_TO_MOVE = 4;

    private Integer position = 0;

    public void move(Integer number) {
        if (isMovable(number)) {
            this.position++;
        }
    }

    public Integer getPosition() {
        return position;
    }

    private static boolean isMovable(Integer number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }
}
