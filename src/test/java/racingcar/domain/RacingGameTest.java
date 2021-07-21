package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @ParameterizedTest
    @DisplayName("객체 생성 테스트")
    @ValueSource(ints = {1, 2, 3})
    void create(final int numberOfCars) {
        assertDoesNotThrow(() -> new RacingGame(numberOfCars));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("게임 실행 테스트")
    void start(final int numberOfCars) {
        RacingGame racingGame = new RacingGame(numberOfCars);
        List<Car> cars = racingGame.start();

        assertEquals(cars.size(), numberOfCars);
        cars.forEach(r -> assertTrue(r.getNumberOfMove() == 1 || r.getNumberOfMove() == 0));
    }
}
