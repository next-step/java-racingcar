package step4;

public class Car {


    // 구분
    private String carName;
    private int location;
    private CarMoveStrategy carMoveStrategy;

    public Car(String carsName, int location, CarMoveStrategy carMoveStrategy) {
        this.carName = carsName;
        this.location = location;
        this.carMoveStrategy = carMoveStrategy;
    }

    public void move() {
        this.location += carMoveStrategy.getMoveCount();
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }


}
