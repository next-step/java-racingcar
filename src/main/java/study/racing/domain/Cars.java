package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = new ArrayList<>(carList);
    }

    public static Cars initOfCar(int carCount) {
        return new Cars(initOfCarList(carCount));
    }

    public static Cars initOfCar(CarRaceInput carRaceInput) {
        return new Cars(initOfCarList(carRaceInput));
    }

    public static List<Car> initOfCarList(int carCount) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car.Builder()
                    .setCarNo(i)
                    .setMoveCount(0)
                    .build());
        }
        return cars;
    }

    public static List<Car> initOfCarList(CarRaceInput carRaceInput) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carRaceInput.getCarCount(); i++) {
            cars.add(new Car.Builder()
                    .setCarName(carRaceInput.getCarNames().get(i))
                    .setMoveCount(0)
                    .build());
        }
        return cars;
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);

    }
}
