package step4;

public class Car {

    // 구분
    int carNumber;
    int location;
    CarMoveStrategy carMoveStrategy;

    public Car(int carNumber, int location, CarMoveStrategy carMoveStrategy) {
        this.carNumber = carNumber;
        this.location = location;
        this.carMoveStrategy = carMoveStrategy;
    }

    public void move() {
        this.location += carMoveStrategy.getMoveCount();
    }

    public int getLocation() {
        return location;
    }

}
