package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Winners findWinners() {
        return new Winners(filterWinners(getMaxPosition()));
    }

    private List<Car> filterWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(car -> car.getPosition().getPosition()))
                .get()
                .getPosition()
                .getPosition();
    }

    public List<Car> getCars() {
        return cars;
    }
}
