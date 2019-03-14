package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest{
    @Test
    public void init_racing_game_with_number() {
        RacingGame racingGame = new RacingGame(
            new MockRacingGameInfo(new MockRule(), 3, 3));

        Assertions.assertThat(racingGame.getGameCount()).isEqualTo(3);
        Assertions.assertThat(racingGame.getCars().size()).isEqualTo(3);
    }

    @Test
    public void init_racing_game_with_car_names() {
        String carNames = "number1, number2, number3";
        RacingGame racingGame = new RacingGame(
            new MockRacingGameInfo(new MockRule(), 3, carNames));

        Assertions.assertThat(racingGame.getGameCount()).isEqualTo(3);
        Assertions.assertThat(racingGame.getCars().size()).isEqualTo(3);
    }

    @Test(expected = IllegalStateException.class)
    public void didnt_set_game_info() {
        RacingGame racingGame = new RacingGame(
            new MockRacingGameInfo(null, 0, 0));
        racingGame.play();
    }

    @Test
    public void all_car_moved_after_game_started() {
        RacingGame racingGame = new RacingGame(
            new MockRacingGameInfo(new MockRule(), 3, 3));

        RacingGameResult racingGameResult = racingGame.play();

        assertThat(racingGameResult.getRoundResults().size()).isEqualTo(3);
        for (Car car : racingGame.getCars()) {
            assertThat(car.getMileage()).isEqualTo(3);
        }
    }

    static class MockRacingGameInfo extends RacingGameInfo{
        public MockRacingGameInfo(Rule rule, Integer gameCount, Integer carCount) {
            super(rule, gameCount, carCount);
        }

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
