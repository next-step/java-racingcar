package racingcar.collection;

import racingcar.Car;
import racingcar.model.MoveResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarList {
    private final List<Car> cars = new ArrayList<>();

    public void participate(Car car) {
        cars.add(car);
    }

    public List<MoveResultDto> moveAllAndGetMoveResultList() {
        cars.forEach(Car::move);

        return cars.stream()
                .map(Car::getMoveResultDto)
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPositionValue)
                .max()
                .getAsInt();
    }

    public List<Winner> getWinners(int winnerPosition) {
        return cars.stream()
                .filter(car -> car.currentPositionEqualsTo(winnerPosition))
                .map(car -> new Winner(car.getName()))
                .collect(Collectors.toList());
    }
}
