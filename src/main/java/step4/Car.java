package step4;

/*
 * Java Racing Game
 * Car
 * ver. 1.0
 * 2020.05.27
 * Copyright ...
 */
public class Car {

    // 구분
    private final String carName;
    private int location;
    private CarMoveStrategy carMoveStrategy;

    public Car(String carsName, int location, CarMoveStrategy carMoveStrategy) {

        if (carsName.isEmpty() || location < 0) {
            throw new IllegalArgumentException("Null or Empty");
        }


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
