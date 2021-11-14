package racingcar.domain.collection;

import racingcar.domain.RacingCar;
import racingcar.service.util.Validation;

import java.util.List;
import java.util.stream.Collectors;

public final class CarCollection {
    private CarCollection() {

    }

    public static List<RacingCar> racingGameReady(List<String> carName) {

        Validation.nullValueCheck(carName);

        return carName.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

}
