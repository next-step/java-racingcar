package racingcar.model;

import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;

import java.util.Objects;

public class Car {
    protected static final int MOVABLE_NUMBER = 4;
    private static final NumberGenerator DEFAULT_NUMBER_GENERATOR = new RandomNumberGenerator();

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(name, Position.DEFAULT);
    }

    protected Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move() {
        move(DEFAULT_NUMBER_GENERATOR);
    }

    /**
     * 숫자 생성기 값에 따라 이동하였다면 true, 이동하지 않았더라면 false를 리턴합니다.
     *
     * @param numberGenerator 숫자 생성기
     * @return 이동하였다면 true, 이동하지 않았더라면 false
     */
    protected boolean move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVABLE_NUMBER) {
            this.position.increase();
            return true;
        }

        return false;
    }

    public boolean matchPosition(int position) {
        return this.position.match(position);
    }

    public String toName() {
        return this.name.toString();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.name, this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
