package racingcar;

import java.util.Arrays;

public class Response {

    private final CarVO[] cars;

    public Response(Car[] cars) {
        this.cars = Arrays.stream(cars).map(CarVO::new).toArray(CarVO[]::new);
    }

    public CarVO[] getCars() {
        return cars;
    }
}
