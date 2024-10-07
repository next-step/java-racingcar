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

    public static List<Car> initOfCarList(int carCount) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car(i, 0));
        }
        return cars;
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);

    }
}
