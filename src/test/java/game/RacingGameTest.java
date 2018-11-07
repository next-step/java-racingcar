package game;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame game;

    @Before
    public void setUp() {
        game = new RacingGame(2, 5);
    }

    @Test
    public void 리스트사이즈_2() {
        List<Car> cars = game.getCars();
        assertThat(cars.size()).isNotNull().isEqualTo(2);
    }
}