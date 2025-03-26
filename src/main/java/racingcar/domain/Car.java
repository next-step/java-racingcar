package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.List;
import java.util.Objects;

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
        if(name != null && name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format( "length of name should be less than %d", NAME_MAX_LENGTH));
        }
    }

    private void validatePositive(int position) {
        if (position < POSITION_MIN_VALUE) {
            throw new IllegalArgumentException("position은 0 이상이어야 합니다. position:" + position);
        }
    }

    public CarState move(NumberGenerator numberGenerator) {
        if (isMovable(numberGenerator)) position++;
        return getCarState();
    }

    public CarState getCarState() {
        return new CarState(name, position);
    }

    public void addName(List<String> names) {
        names.add(name);
    }

    private boolean isMovable(NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }

    public int max(int compare) {
        return Math.max(position, compare);
    }

    public boolean isPositionSame(int winnerPosition) {
        return position == winnerPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}