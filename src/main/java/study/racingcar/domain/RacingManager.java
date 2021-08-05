package study.racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingManager {

    private Cars cars;

    public RacingManager(String nameOfCars) {
        String[] carNameList = nameOfCars.split(",");
        makeRacingCar(carNameList);
    }

    public void startRacing() {
        cars.moveRacingCar();
    }
    

    private void makeRacingCar(String[] carNameList) {
        List<Car> ragingCarList = new ArrayList<>();
        for (String carName : carNameList) {
            ragingCarList.add(new Car(carName));
        }

        ragingCarList = Collections.unmodifiableList(ragingCarList);
        this.cars = new Cars(ragingCarList);
    }


    public List<Car> getCarList() {
        return cars.getRagingCarList();
    }

    public List<Car> getRacingWinners() {
        return cars.getRacingWinners();
    }
}
