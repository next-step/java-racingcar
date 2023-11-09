package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {

    @DisplayName("4이상일때 차가 한 칸 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1"}, delimiter = ':')
    void isCarMoveable(int input, int expectedIdx) {
        Car car = new Car();
        car.moveForward(input);
        assertThat(car.getPosition()).isEqualTo(expectedIdx);
    }

    @DisplayName("자동차명이 5글자를 초과할떄 exception test")
    @ParameterizedTest
    @ValueSource(strings = {"nextstep", "unlucky"})
    void setCarName(String input) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Car(input)).withMessageMatching("자동차명은 5글자를 넘길 수 없습니다 : .*");
    }
}
