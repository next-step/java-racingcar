package step3_racingCar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new LinkedList<Car>();
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public LinkedList<Integer> checkForward(){
        LinkedList<Integer> forwardNums = new LinkedList<>();
        cars.stream().forEach(car -> {
            forwardNums.add(car.getForwardNum());
        });
        return forwardNums;
    }

    public void tryForward(){
        cars.stream().forEach(car -> car.goForward());
    }
}
