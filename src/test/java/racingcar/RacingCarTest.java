package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("자동차 경주에 쓰여지는 자동차 상태")
class RacingCarTest {
    @ParameterizedTest
    @CsvSource(value = {"false:0", "true:1"}, delimiter = ':')
    @DisplayName("전진시 위치가 증가하고 멈춤시 위치가 변함이 없음을 확인한다.")
    void move(boolean isMove, int expected) {
        //given
        RacingCar racingCar = new RacingCar();

        //when
        int result = racingCar.move(() -> isMove);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "4:1"}, delimiter = ':')
    @DisplayName("4이상일 경우엔 위치가 증가하고 4이하시에 위치가 변함이 없음을 확인한다.")
    void isMove(int movingNumber, int expected) {
        //given
        RacingCar racingCar = new RacingCar();

        //when
        boolean isMoving = racingCar.isMove(movingNumber);

        //then
        int result = racingCar.move(() -> isMoving);
        assertThat(result).isEqualTo(expected);
    }
}