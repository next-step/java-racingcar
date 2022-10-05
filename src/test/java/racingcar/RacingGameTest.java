package racingcar;

import exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarErrorCode;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    @DisplayName("이동 횟수를 음수로 넘기면 테스트가 실패한다.")
    void 이동_횟수_음수_실패() {
        Assertions.assertThatThrownBy(() -> RacingGame.race("pobi,crong,honux", -1))
                .isInstanceOf(CustomException.class)
                .hasMessage(RacingCarErrorCode.MOVE_NUMBER_BAD_REQUEST.getMessage());
    }

    @Test
    @DisplayName("컴마(,) 구분자로 이름을 넘기면 참여자 배열을 반환한다.")
    void 자동차_이름_분리() {
        String input = "pobi,crong,honux";
        List<Car> race = RacingGame.race(input, 3);
        assertThat(race).extracting("name")
                .containsOnly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("가장 먼 거리를 전진한 우승자들을 리스트로 반환한다.")
    void 우승자_뽑아내기() {
        final int winnerLocation = 4;

        Car firstCar = Car.from(winnerLocation);
        Car firstCar2 = Car.from(winnerLocation);
        Car secondCar = Car.from(winnerLocation-1);
        Car thirdCar = Car.from(winnerLocation-2);

        List<Car> cars = new ArrayList<>();
        cars.add(firstCar);
        cars.add(firstCar2);
        cars.add(secondCar);
        cars.add(thirdCar);

        List<Car> winners = RacingGame.getWinners(cars);

        assertThat(winners).extracting("location")
                .containsOnly(winnerLocation);
    }
}
