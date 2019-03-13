package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RacingGameTest{
    @Test
    public void init_game_anonymous_car() {
        RacingGame racingGame = new RacingGame(new MockRule(), 3, 3);

        Assertions.assertThat(racingGame.getGameCount()).isEqualTo(3);
        Assertions.assertThat(racingGame.getCars().size()).isEqualTo(3);
    }

    @Test
    public void init_game_named_car() {
        String[] carNames = {"number1", "number2", "number3"};
        RacingGame racingGame = new RacingGame(new MockRule(), 3, carNames);

        Assertions.assertThat(racingGame.getGameCount()).isEqualTo(3);
        Assertions.assertThat(racingGame.getCars().size()).isEqualTo(3);
    }

    @Test
    public void check_all_car_moved_if_game_started() {
        RacingGame racingGame = new RacingGame(new MockRule(), 3, 3);

        List<Car> cars = racingGame.play();

        for (Car car : cars) {
            assertThat(car.getMileage()).isEqualTo(3);
        }
    }

    static class MockRule implements Rule {
        @Override
        public boolean canPass() {
            return true;
        }
    }
}
