package step4.domain;

import step4.exception.OutBoundCarListSizeException;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
        System.out.println(this.cars.size());
    }


    public void moveCars(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getCarsStatus() {
        return cars;
    }

}
