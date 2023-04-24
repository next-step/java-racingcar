package study.step3;

import java.util.List;

public class CarRacing {
    private Cars cars;

    void initRacing(String[] carNames) {
        cars = new Cars(carNames);
    }

    List<Car> moveCars() {
        cars.moveCars();
        return cars.asList();
    }

    Cars getCars() {
        return cars;
    }

}
