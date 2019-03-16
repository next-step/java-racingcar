package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest{
    @Test
    public void init_racing_game_with_car_names() {
        String carNames = "number1, number2, number3";
        RacingGame racingGame = new RacingGame(
            new MockRacingGameInfo(new MockRule(), 3, carNames));

        Assertions.assertThat(racingGame.getGameCount()).isEqualTo(3);
        Assertions.assertThat(racingGame.getCars()).hasSize(3);
    }

    @Test
    public void all_car_moved_after_game_started() {
        RacingGame racingGame = new RacingGame(
            new MockRacingGameInfo(new MockRule(), 3, "a,b,c"));

        RacingGameResult racingGameResult = racingGame.play();

        assertThat(racingGameResult.getRoundResults()).hasSize(3);
        for (Car car : racingGame.getCars()) {
            assertThat(car.getMileage()).isEqualTo(3);
        }
    }

    static class MockRacingGameInfo extends RacingGameInfo{
        public MockRacingGameInfo(Rule rule, Integer gameCount, String carNames) {
            super(rule, gameCount, carNames);
        }
    }

    static class MockRule implements Rule {
        @Override
        public boolean canPass() {
            return true;
        }
    }
}
