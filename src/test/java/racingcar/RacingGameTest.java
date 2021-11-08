package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.collection.Race;
import racingcar.collection.RaceResult;
import racingcar.collection.Winners;
import racingcar.model.RacingGameRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


class RacingGameTest {

    @Test
    @DisplayName("playRace 메소드는 자동차들을 경주시키고 RaceResult를 반환한다")
    public void 테스트_RacingGame_playRace() {
        final String carNames = "pobi,crong,honux";
        final int countOfTry = 3;

        RacingGame racingGame = new RacingGame(new RacingGameRequest(carNames, countOfTry));
        RaceResult raceResult = racingGame.playRace();

        assertThat(raceResult.getHistories().size()).isEqualTo(countOfTry);

        List<Race> histories = raceResult.getHistories();
        Race lastRace = histories.get(histories.size() - 1);
        int winnerPosition = lastRace.getCars().stream()
                .mapToInt(car ->
                        car.getCurrentPosition().getPosition())
                .max()
                .getAsInt();

        Winners winners = raceResult.getWinners();
        assertThat(winners.getCars().size()).isGreaterThan(0);
        assertTrue(winners.getCars().stream().allMatch(car ->
                car.getCurrentPosition().getPosition() == winnerPosition));

    }
}