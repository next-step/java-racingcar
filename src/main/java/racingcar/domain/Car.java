package racingcar.domain;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(){
        this(null, 0);
    }

    public Car(int position){
        this(null, position);
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position){
        validatePositive(position);
        this.position = position;
        this.name = name;
    }

    private void validatePositive(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 0 이상이어야 합니다. position:" + position);
        }
    }

    public int move(NumberGenerator numberGenerator) {
        if (isMovable(numberGenerator)) incrementPosition();
        return position;
    }

    private boolean isMovable(NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }

    private void incrementPosition() {
        position++;
    }

}