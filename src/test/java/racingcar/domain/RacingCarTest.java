package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingCarTest {
    @DisplayName("레이싱 자동차를 전진 시킴")
    @Test
    void go() {
        RacingCar car = RacingCar.attend();
        MotorRacingRule moveRule = () -> true;
        car.racing(moveRule);
        RacingResult result = car.getResult();
        assertThat(result.getTotalMileage()).isPositive();
    }

    @DisplayName("레이싱 자동차를 정지 시킴")
    @Test
    void stop() {
        RacingCar car = RacingCar.attend();
        MotorRacingRule moveRule = () -> false;
        car.racing(moveRule);
        RacingResult result = car.getResult();
        assertThat(result.getTotalMileage()).isZero();
    }

    @DisplayName("자동차 이름 정상 등록 한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde", "a1234"})
    void validNameTest(final String testName) {
        int length = RacingCar.attend(testName)
                              .getResult()
                              .getPrefix()
                              .length()
            ;
        assertThat(length).isLessThanOrEqualTo(NamedRacingCar.MAX_NAME_LEN);
    }

    @DisplayName("자동차 이름 잘못 등록 한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "null", "abcdef", "1aaa"})
    void invalidNameTest(final String carName) {
        String testName = "null".equals(carName) ? null : carName;
        assertThatIllegalArgumentException()
            .isThrownBy(()->RacingCar.attend(testName))
            .withMessage(NamedRacingCar.ERROR_MSG_CAR_NAME);
    }
}