package racingcar.domain.gameround;

import racingcar.domain.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarCountGameRound implements GameRound {

    @Override
    public List<String> getResult(Cars cars) {
        return cars.getCarList().stream()
                .map(car -> car.printPosition())
                .collect(Collectors.toList());
    }
}