package racingcar.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RacingDice;

class RacingTest {

    @DisplayName("입력한 자동차의 수 만큼 Race 결과가 나오는 지 테스트")
    @Test
    public void joinRaceTest() {
        Dice dice = new RacingDice(RacingDice.RACING_MAX_BOUND);
        Racing race = new Racing(dice, 3);
        int carCount = 10;
        race.joinRace(carCount);

        race.start(gameResults ->
                Assertions.assertThat(gameResults.size()).isEqualTo(10));
    }
}