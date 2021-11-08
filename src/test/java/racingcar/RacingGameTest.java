package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.collection.RaceHistories;
import racingcar.model.RacingGameRequest;

import static org.assertj.core.api.Assertions.assertThat;


class RacingGameTest {

    @Test
    @DisplayName("playRace 메소드는 자동차들을 경주시키고 RaceHistories를 반환한다")
    public void 테스트_RacingGame_playRace() {
        final int countOfCar = 5;
        final int countOfTry = 3;

        RacingGame racingGame = new RacingGame(new RacingGameRequest(countOfCar, countOfTry));
        RaceHistories raceHistories = racingGame.playRace();

        assertThat(raceHistories.getHistories().size()).isEqualTo(countOfTry);

    }
}