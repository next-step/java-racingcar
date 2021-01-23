package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class GameTest {

    @Test
    @DisplayName("getWinners 테스트")
    public void getWinnersTest() {
        final Game game = new Game();
        List<Car> test = GenerateCar.ofCars("a,b,c");
        assertThat(game.getWinners(test)).isEqualTo("a,b,c");
    }

}
