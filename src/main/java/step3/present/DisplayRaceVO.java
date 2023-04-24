package step3.present;

import step3.model.Car;
import step3.model.Result;

public class DisplayRaceVO {
    private final Result result;
    private final Car car;

    public DisplayRaceVO(Result result, Car car) {
        this.result = result;
        this.car = car;
    }

    public Result getResult() {
        return result;
    }

    public Car getCar() {
        return car;
    }
}
