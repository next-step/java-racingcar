package step3;

import step3.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRacing {
    private Cars cars;

    public CarRacing(int carNumbers, MoveStrategy moveStrategy) {
        cars = new Cars(carNumbers, moveStrategy);
    }

    public void moveCars() {
        cars.moveCars();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
