package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by owen.ny on 2021/11/05.
 */
class RacingGameTest {


    @Test
    @DisplayName("race 메소드는 자동차들을 경주시키고 자동차들의 현재 위치 리스트를 반환한다")
    public void 테스트_RacingGame_race() {
        final int countOfCar = 5;

        RacingGame racingGame = new RacingGame(countOfCar);
        List<Integer> raceResult = racingGame.race();

        assertThat(raceResult.size()).isEqualTo(countOfCar);
        assertTrue(raceResult.stream().allMatch(element -> element >= 0));
    }
}