package racingcar.domain.collection;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.service.util.Validation;

import java.util.List;
import java.util.stream.Collectors;

public final class CarCollection {
    private CarCollection() {

    }

    public static RacingCars racingGameReady(List<String> carName) {

        Validation.nullValueCheck(carName);

        List<RacingCar> racingCars = carName.stream()
                                    .map(RacingCar::create)
                                    .collect(Collectors.toList());

        return new RacingCars(racingCars);
    }
}
