package step5.domain;

import step5.utils.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    private Cars() {
        carList = new ArrayList<>();
    }

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars from(String names) {
        Cars cars = new Cars();
        cars.carListToParticipate(names);
        return cars;
    }

    public static Cars from(List<Car> carList) {
        return new Cars(carList);
    }

    private void carListToParticipate(String CarNames) {
        List<String> nameList = StringUtil.toList(CarNames);
        for (String name : nameList) {
            Car car = new Car(name);
            carList.add(car);
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

}
