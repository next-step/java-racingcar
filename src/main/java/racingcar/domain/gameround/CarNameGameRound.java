package racingcar.domain.gameround;

import racingcar.domain.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarNameGameRound implements GameRound {

    @Override
    public List<String> getResult(Cars cars) {
        return cars.getCarList().stream()
                .map(car -> car.getName() + ":" + car.printPosition())
                .collect(Collectors.toList());
    }
}