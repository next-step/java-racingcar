package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.RacingGame.moveCarForward;
import static racingcar.domain.RacingGame.racingStart;

public class RacingGameTest {
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void init() {
        cars.add(new Car("애플"));
        cars.add(new Car("삼성"));
        cars.add(new Car("구글"));
    }

    @Test
    void 경주시작_임의값_성공() {
        String carsName = "애플,삼성,구글";
        racingStart(carsName, 5);
    }

    @Test
    void 자동차_전진_성공() {
        moveCarForward(cars);
    }
}
