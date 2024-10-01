package racinggame.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> cars;

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(MoveStrategy strategy) {
        cars.add(new RacingCar(new CarPosition(), strategy));
    }

    public boolean allCarsAtStartPosition() {
        return cars.stream().allMatch(RacingCar::isAtStartPosition);
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

}
