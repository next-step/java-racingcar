package study03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car;
    @BeforeEach
    void create() {
        car = new Car();
    }

    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName("0~9의 임의의 조건값 생성")
    void 조건값생성() {
        assertThat(car.createConditionNumber()).isGreaterThanOrEqualTo(0);
        assertThat(car.createConditionNumber()).isLessThanOrEqualTo(9);
    }

    @DisplayName("moveByCondition()메소드 검증-전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진(Integer forwardNumber) {
        assertThat(Optional.of(forwardNumber).filter(cnt -> cnt >= 4).map(i -> "-").orElseGet(() -> null)).isEqualTo("-");
    }

    @DisplayName("moveByCondition()메소드 검증-멈춤")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 멈춤(Integer stopNumber) {
        assertThat(Optional.of(stopNumber).filter(cnt -> cnt >= 4).map(i -> "-").orElseGet(() -> null)).isNull();
    }

}