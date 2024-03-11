package racingcar.step3;

import racingcar.step3.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Round {

    private final MoveStrategy moveStrategy;
    private final List<Car> cars;

    public Round(MoveStrategy moveStrategy, int carsNumber) {
        this.moveStrategy = moveStrategy;
        this.cars = createCarsList(carsNumber);
    }

    public void startRound() {
        cars.forEach(Car::move);
    }

    public List<Integer> getCarsCurrentDistance() {
        return cars.stream()
                .map(Car::getCurrentLocation)
                .collect(Collectors.toList());
    }

    private List<Car> createCarsList(int carNumbers) {
        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < carNumbers; i++) {
            cars.add(new Car(moveStrategy));
        }

        return cars;
    }
}
