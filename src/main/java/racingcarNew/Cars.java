package racingcarNew;

import racingcarNew.domain.Car;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int getCount() {
        return cars.size();
    }
}
