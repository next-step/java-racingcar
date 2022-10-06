package racing.domain;

import racing.strategy.CarMoveStrategy;

import java.util.Objects;

public class Car {
    private final static String TIRE_MARK = "-";
    private CarPosition position;
    private CarMoveStrategy carMoveStrategy;
    private CarName name;

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
        this.carMoveStrategy = new CarMoveStrategy();
    }

    public Car(String name, int position) {
        this(new CarName(name), new CarPosition(position));
    }

    public Car(String name) {
        this(new CarName(name), new CarPosition());
    }

    public String getTireMark() {
        return TIRE_MARK;
    }

    public void move(int randomNum) {
        if (canMove(randomNum)) {
            position.move();
        }
    }

    public boolean canMove(int randomNum) {
        return carMoveStrategy.canMove(randomNum);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return this.name.getName();
    }

    public String getSkidMark() {
        String skidMark = getName() + " : ";
        for (int i = 0; i < this.getPosition(); i++) {
            skidMark += this.getTireMark();
        }
        return skidMark;
    }

    public boolean isWinner(int winnerPosition) {
        return this.position.equals(new CarPosition(winnerPosition));
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

        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, carMoveStrategy, name);
    }
}
