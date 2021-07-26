package study.racing.domain;

public class Car {

    private static final int LIMIT_NUMBER = 4;

    private Distance distance;

    private Name name;

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

    private static Boolean checkMoveableCar(int targetNumber) {
        return targetNumber >= LIMIT_NUMBER;
    }

    public void moveTheCar(int randomNumber) {
        if(checkMoveableCar(randomNumber)){
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
