package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.strategyPattern.MoveStrategy;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    @DisplayName("입력된 자동차 대수만큼 RacingCar 객체를 생성한다")
    void createCarList_자동차대수(int carCount) {
        List<RacingCar> carList = RacingCarGame.createCarList(carCount);
        int actual = carList.size();
        int expected = carCount;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전략에 따라 랜덤값이 0이상 3이하인 경우 자동차는 정지한다")
    void playRoundsAndReturnCarList_정지() {
        RacingCar racingCar = new RacingCar();
        int beforePostion = racingCar.getPosition();
        MoveStrategy noMoveStrategy = () -> false;

        racingCar.moveForward(noMoveStrategy);

        int afterPosition = racingCar.getPosition();
        assertThat(beforePostion).isEqualTo(afterPosition);
    }

    @Test
    @DisplayName("전략에 따라 랜덤값이 0이상 3이하인 경우 자동차는 정지한다")
    void playRoundsAndReturnCarList_전진() {
        RacingCar racingCar = new RacingCar();
        int beforePostion = racingCar.getPosition();
        MoveStrategy noMoveStrategy = () -> true;

        racingCar.moveForward(noMoveStrategy);

        int afterPosition = racingCar.getPosition();
        assertThat(beforePostion + 1).isEqualTo(afterPosition);
    }
}