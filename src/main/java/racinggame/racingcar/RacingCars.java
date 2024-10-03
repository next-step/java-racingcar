package racinggame.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> cars;

    private RacingCars(List<RacingCar> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static RacingCars create(MoveStrategy moveStrategy, List<String> nameList) {
        List<RacingCar> cars = nameList.stream()
                .map(name -> RacingCar.create(moveStrategy, name))
                .collect(Collectors.toList());

        return new RacingCars(cars);
    }

    public int count() {
        return cars.size();
    }

    public void moveAll() {
        cars.forEach(RacingCar::move);
    }

    public List<Integer> getCurrentPositionsRepresentation() {
        return cars.stream()
                .map(RacingCar::getCurrentPosition)
                .collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }
}
