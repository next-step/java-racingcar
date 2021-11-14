package racingcar.domain.collection;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public final class CarCollection {
    private CarCollection() {

    }

    public static List<RacingCar> racingGameReady(List<String> carName) {

        return carName.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

}
