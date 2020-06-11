package step4;

import org.junit.jupiter.api.Test;
import step4.model.Cars;
import step4.model.Game;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void create() {
        int round = 1;
        Cars cars = new Cars("peter,kassie,oak");
        Game game = new Game(cars, round);
        assertThat(game).isEqualTo(new Game(cars, round));
    }
}
