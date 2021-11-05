package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.collection.RacingResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {


    @Test
    @DisplayName("race 메소드는 자동차들을 경주시키고 자동차들의 현재 위치 리스트를 반환한다")
    public void 테스트_RacingGame_race() {
        final int countOfCar = 5;

        RacingGame racingGame = new RacingGame(countOfCar);
        RacingResult raceResult = racingGame.race();

        assertThat(raceResult.getPositions()).isEqualTo(countOfCar);
    }
}