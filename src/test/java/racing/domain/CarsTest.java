package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {
        "monds:1",
        "pobi,crong,honux:3"
    }, delimiter = ':')
    @DisplayName("주어진 자동차 수 만큼 생성하는지 확인")
    void testCreateCars(String input, int count) {
        Cars cars = new Cars(input);
        assertThat(cars.size()).isEqualTo(count);
    }

    @Test
    @DisplayName("모든 자동차 전진")
    void testMoveAll() {
        // given
        Cars cars = new Cars("pobi,crong,honux");
        // when
        cars.moveAll(() -> true);
        // then
        cars.iterateCar(distance -> assertThat(distance.getMovedDistance()).isEqualTo(1));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름이 null 또는 empty 일 경우 예외")
    void testCreateCarsWithNullOrEmptyInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(input));
    }

    @Test
    @DisplayName("최대 이동 거리")
    void testGetMaxMoveDistance() {
        // given
        Cars cars = new Cars("pobi,crong,honux");
        // when
        cars.moveAll(() -> true);
        // then
        assertThat(cars.getMaxMovedDistance()).isEqualTo(1);
    }
}
