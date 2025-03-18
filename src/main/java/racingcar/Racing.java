package racingcar;

import java.util.List;

public class Racing {
    private final List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        cars.forEach(Car::play);
    }

    public String getRacingStatus() {
        StringBuilder result = new StringBuilder();
        cars.stream().forEachOrdered(car -> {
            for (int i = 0; i < car.getDistance(); i++) {
                result.append("-");
            }
            result.append("\n");
        });
        return result.toString();
    }
}