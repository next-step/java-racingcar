package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car = new Car();

    @Test
    @DisplayName("자동차 검증 - 출발지 확인")
    void checkStartingPoint() {
        assertThat(car.getPosition()).isEqualTo("-");
    }

    @ParameterizedTest
    @DisplayName("자동차 검증 - 이동 여부 검증")
    @CsvSource(
            delimiter = '|',
            value = {"true|'--'", "false|'-'"}
    )
    void moveForward(boolean move, String expected) {
        car.move(move);
        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
