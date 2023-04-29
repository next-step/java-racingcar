package racingcar.car;

import java.util.List;

public class CarResource {

    private final List<String> cars;

    private CarResource(List<String> cars) {
        this.cars = cars;
    }

    public static CarResource from(List<String> cars){
        return new CarResource(cars);
    }

    public List<String> getCars(){
        return cars;
    }
}
