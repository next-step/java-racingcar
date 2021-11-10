package racingcar.domain.collection;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarCollection {
    private CarCollection() {

    }

    public static List<RacingCar> racingGameReady(int count) {

        return Stream.generate(RacingCar::create)
                .limit(count).collect(Collectors.toList());
    }

}
