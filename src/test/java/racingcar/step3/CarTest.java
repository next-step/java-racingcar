package racingcar.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("파라미터 값이 0~3의 값으로 들어오면 자동차의 위치는 변경되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void stopCarWhenSignBetweenZeroToThree(int Sign) {
        // when
        car.decideAction(Sign);

        // then
        assertThat(car.getCurrentLocation()).isEqualTo("");
    }

    @DisplayName("파라미터 값이 4이상으로 들어오면 자동차의 위치는 +1이 된다.")
    @ParameterizedTest
    @CsvSource(value = {"4:1:-", "5:4:----", "9:3:---"}, delimiter = ':')
    void stopCarWhenSignBetweenZeroToThree(int Sign, int repeatCount, String carExpectedLocation) {
        // when
        for (int i = 0; i < repeatCount; i++) {
            car.decideAction(Sign);
        }

        // then
        assertThat(car.getCurrentLocation()).isEqualTo(carExpectedLocation);
    }

    @DisplayName("0~9외의 값을 입력하면 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 100, -100})
    void throwIllegalArgumentExceptionWithInvalidSign(int sign) {
        // then
        assertThrows(IllegalArgumentException.class, () -> car.decideAction(sign));
    }

    @DisplayName("차량의 현재 위치만큼 '-'를 출력한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:---", "2:--", "1:-"}, delimiter = ':')
    void printWithDashOfCurrentCarLocation(int moveCount, String visualizedCurrentLocation) {
        // given
        for (int i = 0; i < moveCount; i++) {
            car.decideAction(4);
        }

        // then
        assertThat(car.getCurrentLocation()).isEqualTo(visualizedCurrentLocation);
    }

}