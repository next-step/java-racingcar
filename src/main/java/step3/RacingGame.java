package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int roundTime;
    private int carCount;
    private List<Car> carList = new ArrayList<Car>();

    public void createCars(int carCount) {
        List<Car> carList = new ArrayList<Car>();

        for(int i = 0; i < carCount; i++) {
            carList.add(_createCar());
        }
        this.carList = carList;
    }

    private Car _createCar() {
        Car car = new Car();

        return car;
    }

    public void move(int presentRoundTime) {
        for(Car car: this.carList) {
            car.playRound(presentRoundTime);
        }
    }

    public List<Car> play(int roundTime, int carCount) {
        createCars(carCount);
        for(int i = 1; i <= roundTime; i++) {
            move(i);
        }
        return carList;
    }
}


