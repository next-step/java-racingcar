package racinggame.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameInitializerTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("주어진 값만큼 차를 생성하기")
    void init_cars(int numOfCar) {
        List<Car> cars = GameInitializer.initCars(numOfCar);

        assertThat(cars).hasSize(numOfCar);
    }

}