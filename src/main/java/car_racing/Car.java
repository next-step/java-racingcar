package car_racing;


import java.util.Objects;

public class Car {
    private Integer carNumber;
    private Integer straightCount;

    public Car(Integer carNumber) {
        this.carNumber = carNumber;
        this.straightCount = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return carNumber.equals(car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }

    public void tryMove(int givenCondition) {
        if (GameRule.isGoStraight(givenCondition)) {
            move();
        }
    }

    private void move() {
        this.straightCount += 1;
    }

    public Integer getStraightCount() {
        return straightCount;
    }
}
