package racingcar.domain;

import exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
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
    @DisplayName("이동 횟수를 음수로 넘기면 테스트가 실패한다.")
    void moveNumber_negative_false() {
        RacingGame racingGame = new RacingGame("test1,test2,test3");
        assertThatThrownBy(() -> racingGame.race(-1))
                .isInstanceOf(CustomException.class)
                .hasMessage(RacingCarErrorCode.MOVE_NUMBER_BAD_REQUEST.getMessage());
    }

    @Test
    @DisplayName("자동차 경주 참가자가 경주를 진행한다.")
    void race() {
        RacingGame racingGame = new RacingGame("test1,test2,test3");
        List<Car> cars = racingGame.race(5);
        assertThat(cars).hasSize(3);
    }
}
