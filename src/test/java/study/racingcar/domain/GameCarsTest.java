package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("1보다 작은 수를 입력할 때 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void exception_occur_when_input_is_less_than_one(int carNum) {

        assertThatThrownBy(() -> new GameCars(carNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1보다 큰 수를 입력하세요");
    }

    @DisplayName("1보다 같거나 큰 수 입력시 예외 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,10,100})
    void exception_occur_when_input_is_eqaul_or_greater_than_one(int carNum) {
        assertThatNoException()
                .isThrownBy(() -> new GameCars(carNum));
    }
}