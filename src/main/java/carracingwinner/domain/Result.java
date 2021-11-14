package carracingwinner.domain;

import java.util.List;

public class Result {

    private final String result;

    public Result(List<Car> cars) {
        this.result = makeResult(cars);
    }

    private String makeResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> {
            sb.append(car.showCurrentState()).append('\n');
        });
        return sb.toString();
    }

    public String getResult() {
        return result;
    }

}
