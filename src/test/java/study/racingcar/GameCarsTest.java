package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameCarsTest {

    @DisplayName("개수 만큼 list를 생성하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10, 1000})
    void generate_cars_as_same_size_with_input(int carNum) {
        // when
        GameCars cars = new GameCars(carNum);
        // then
        assertThat(cars).hasSize(carNum);
    }
}