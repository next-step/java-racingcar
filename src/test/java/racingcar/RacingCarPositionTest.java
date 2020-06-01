package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.application.RacingCarPosition;
import racingcar.domain.RacingCar;
import racingcar.utils.Const;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("자동차 경주에 쓰여지는 자동차 상태")
class RacingCarPositionTest {
    @ParameterizedTest
    @CsvSource(value = {"false:0", "true:1"}, delimiter = ':')
    @DisplayName("전진시 위치가 증가하고 멈춤시 위치가 변함이 없음을 확인한다.")
    void move(boolean isMove, int expected) {
        //given
        RacingCarPosition racingCarPosition = new RacingCarPosition(Const.INITIAL_NUM);

        //when
        int result = racingCarPosition.move(() -> isMove);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "4:1"}, delimiter = ':')
    @DisplayName("4이상일 경우엔 위치가 증가하고 4이하시에 위치가 변함이 없음을 확인한다.")
    void isMove(int movingNumber, int expected) {
        //given
        RacingCarPosition racingCarPosition = new RacingCarPosition(Const.INITIAL_NUM);

        //when
        boolean isMoving = racingCarPosition.isMove(movingNumber);

        //then
        int result = racingCarPosition.move(() -> isMoving);
        assertThat(result).isEqualTo(expected);
    }
}