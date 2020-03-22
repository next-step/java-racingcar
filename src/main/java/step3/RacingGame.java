package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int roundTime;
    private int carCount;
    private List<Car> carList = new ArrayList<Car>();

    private void createCars(int carCount) {
        List<Car> carList = new ArrayList<Car>();

        for(int i = 0; i < carCount; i++) {
            carList.add(createCar());
        }
        this.carList = carList;
    }

    private Car createCar() {
        Car car = new Car();

        return car;
    }

    private void _move(int presentRoundTime) {
        for(Car car: this.carList) {
            car.playRound(presentRoundTime);
        }
    }

    public List<Car> play(int carCount, int roundTime) {
        createCars(carCount);
        for(int i = 0; i < roundTime; i++) {
            _move(i);
        }
        return carList;
    }
}


