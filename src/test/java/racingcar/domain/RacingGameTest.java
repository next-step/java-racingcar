package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertDoesNotThrow(() -> new RacingGame(Arrays.asList("pobi", "crong", "honux")));
    }

    @Test
    @DisplayName("게임 실행 테스트")
    void start() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        RacingGame racingGame = new RacingGame(names);
        List<Car> cars = racingGame.start();

        assertEquals(cars.size(), names.size());
        cars.forEach(car -> assertTrue(car.getDistance().getValue() == 1 || car.getDistance().getValue() == 0));
    }
}
