package step3.domain;

import step3.domain.gameStrategy.CarGameStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {

    private final List<Car> carList;

    CarCollection(int numberOfCars) {
        carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
    }

    public void playOneRound(CarGameStrategy carGameStrategy) {
        for (Car car : carList) {
            int distance = carGameStrategy.getDistanceToMove();
            car.move(distance);
        }
    }

    public List<Integer> getPosition(int round) {
        return carList.stream()
                .map(car -> car.getPosition(round))
                .collect(Collectors.toList());

    }

}
