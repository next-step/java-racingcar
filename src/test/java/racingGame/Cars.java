package racingGame;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void start(RandomNumber randomNumber) {
        cars.forEach(car -> car.start(randomNumber));
    }

    public String getPositionView() {
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> result.append(car.getPositionView()).append("\n"));
        return result.toString();
    }
}
