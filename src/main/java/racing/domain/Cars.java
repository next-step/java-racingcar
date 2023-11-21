package racing.domain;

import racing.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private final RandomGenerateNumber randomGenerateNumber;


    public Cars(List<Car> cars) {
        this.cars = cars;
        this.randomGenerateNumber = new RandomGenerateNumber();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars(int retryCount, ResultView resultView) {
        for (int i = 0; i < retryCount; i++) {
            moveCar();
            resultView.print(cars);
        }
    }

    private void moveCar() {
        for (Car car : cars) {
            car.move(randomGenerateNumber);
        }
    }

    public String getWinner() {
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
        return String.join(",", winners);
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
