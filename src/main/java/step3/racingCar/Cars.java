package step3.racingCar;

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
