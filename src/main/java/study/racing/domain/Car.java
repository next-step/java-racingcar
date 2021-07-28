package study.racing.domain;

import study.racing.strategy.CarMovableStrategy;
import study.racing.strategy.MoveStrategy;

public class Car {

    private Distance distance;

    private Name name;

    private MoveStrategy moveStrategy = new CarMovableStrategy();

    public Car() {
        distance = new Distance();
        name = new Name();
    }

    public Car(String carName) {
        distance = new Distance();
        name = new Name(carName);
    }

    public static Car createCar() {
        return new Car();
    }

    public static Car createCar(String carName) {
        return new Car(carName);
    }

    public Distance getDistance() {
        return distance;
    }

    public void moveTheCar(int randomNumber) {
        if(moveStrategy.movable(randomNumber)){
            distance.move();
        }
    }

    public Name getName() {
        return name;
    }

    public int maxDistance(Car car) {
        return distance.getMaxValue(car.getDistance().getMoveDistance());
    }

    public boolean isWinner(int maxMoveDistance) {
        return distance.isSameToMaxDistance(maxMoveDistance);
    }

    public boolean isMaxDistance(Distance distance, int max){
        return distance.isMax(distance.getMoveDistance(), max);
    }
}
