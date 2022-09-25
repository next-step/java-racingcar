package racinggame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.core.GameInitializer.DELIMITER;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameInitializerTest {

    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux")
    @DisplayName("주어진 명단대로 차를 생성하기")
    void init_cars(String carNames) {
        List<Car> cars = GameInitializer.initCars(carNames);

        assertThat(cars).hasSize(carNames.split(DELIMITER).length);
    }

}