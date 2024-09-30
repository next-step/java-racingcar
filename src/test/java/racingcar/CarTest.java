package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("0 ~ 9 사이의 랜덤값을 생성한다.")
    void 랜덤값_생성() {
        Car car = new Car();
        assertThat(car.generateRandomNumber()).isBetween(0, 9);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    @DisplayName("4 이상의 숫자일 때 true를 반환한다.")
    void 숫자_4이상_조건_확인(int number, boolean expected) {
        Car car = new Car();
        assertThat(car.checkGreaterThanOrEqualToMinimumValue(number)).isEqualTo(expected);
    }
}
