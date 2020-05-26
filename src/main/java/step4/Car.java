package step4;

public class Car {


    // 구분
    private String carsName;
    private int location;
    private CarMoveStrategy carMoveStrategy;

    public Car(String carsName, int location, CarMoveRandomStrategy carMoveStrategy) {
        this.carsName = carsName;
        this.location = location;
        this.carMoveStrategy = carMoveStrategy;
    }

    public void move() {
        this.location += carMoveStrategy.getMoveCount();
    }

    public String getCarsName() {
        return carsName;
    }

    public int getLocation() {
        return location;
    }

}
