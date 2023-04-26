package racingcar.input.request;

import racingcar.car.CarResource;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CarRequest {

    private final String cars;

    public CarRequest(String cars) {
        this.cars = cars;
    }

    public CarResource toResource(){
        return CarResource.from(Arrays.stream(cars.split(",")).collect(Collectors.toList()));
    }
}
