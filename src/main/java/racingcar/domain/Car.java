package racingcar.domain;

import racingcar.util.NumberGenerator;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int POSITION_MIN_VALUE = 0;
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
        validateNameLength(name);
        validatePositive(position);
        this.name = name;
        this.position = position;
    }

    private void validateNameLength(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format( "length of name should be less than %d", NAME_MAX_LENGTH));
        }
    }

    private void validatePositive(int position) {
        if (position < POSITION_MIN_VALUE) {
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