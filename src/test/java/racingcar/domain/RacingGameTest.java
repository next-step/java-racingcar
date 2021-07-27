package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rules.MoveRule;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RacingGameTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        List<Car> carList = Collections.singletonList(new Car("pobi", 1));
        Cars cars = new Cars(carList);
        assertDoesNotThrow(() -> new RacingGame(cars, new MoveRule()));
    }
}