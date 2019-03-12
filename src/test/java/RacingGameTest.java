import domain.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest{
    @Test
    public void init_game() {
        RacingGame racingGame = new RacingGame(new MockInput(), new ConsoleOutput(), new MockCondition());
        racingGame.init();

        assertThat(racingGame.getGameCount()).isEqualTo(3);
        assertThat(racingGame.getCars().size()).isEqualTo(3);
    }

    @Test
    public void check_all_car_moved_if_game_started() {
        RacingGame racingGame = new RacingGame(new MockInput(), new ConsoleOutput(), new MockCondition());
        racingGame.init();
        racingGame.play();

        for (Car car : racingGame.getCars()) {
            assertThat(car.getMileage()).isEqualTo(3);
        }
    }

    static class MockCondition implements Condition{
        @Override
        public boolean canPass() {
            return true;
        }
    }

    static class MockInput implements Input{
        @Override
        public int nextInt() {
            return 3;
        }
    }
}
