package racing;

import java.util.List;

public class RoundResult {
    private final List<Car> cars;
    private StringBuilder stringResult = new StringBuilder();

    public RoundResult(List<Car> cars) {
        this.cars = cars;
        setResult();
    }

    public void setResult() {
        for (Car car : cars) {
            stringResult.append(car.getStringDistance());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public StringBuilder getStringResult() {
        return stringResult;
    }
}
