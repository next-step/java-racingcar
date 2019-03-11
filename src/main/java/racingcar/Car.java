package racingcar;

public class Car {
    private static final int LOWER_LIMIT_OF_MOVE = 4;
    private int position = 0;

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generateNumber() >= LOWER_LIMIT_OF_MOVE)
            this.position++;
    }

    public int getPosition() {
        return position;
    }
}
