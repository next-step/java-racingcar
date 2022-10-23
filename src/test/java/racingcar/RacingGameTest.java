package racingcar;

import exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarErrorCode;
import racingcar.exception.RacingCarErrorCode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    @Test
    @DisplayName("참여하는 자동차가 하나도 없는 경우 테스트가 실패한다.")
    void carNames_bad_request_false() {
        assertThatThrownBy(() -> new RacingGame(""))
                .isInstanceOf(CustomException.class)
                .hasMessage(CarErrorCode.CAR_NAME_NOT_BLANK.getMessage());
    }

    @Test
    void carNames_length_bad_request_false() {
        assertThatThrownBy(() -> new RacingGame("test1test2test3,test,test3"))
                .isInstanceOf(CustomException.class)
                .hasMessage(CarErrorCode.CAR_NAME_LENGTH_BAD_REQUEST.getMessage());
    }

    @Test
    @DisplayName("이동 횟수를 음수로 넘기면 테스트가 실패한다.")
    void moveNumber_negative_false() {
        RacingGame racingGame = new RacingGame("test1,test2,test3");
        assertThatThrownBy(() -> racingGame.race(-1))
                .isInstanceOf(CustomException.class)
                .hasMessage(RacingCarErrorCode.MOVE_NUMBER_BAD_REQUEST.getMessage());
    }

    @Test
    void race() {
        RacingGame racingGame = new RacingGame("test1,test2,test3");
        List<Car> cars = racingGame.race(5);
        assertThat(cars).hasSize(3);
    }
}
