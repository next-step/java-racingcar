package racingcarRefactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarRefactor.domain.Car;
import racingcarRefactor.domain.Game;
import racingcarRefactor.domain.GenerateCar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    @DisplayName("getWinners 테스트")
    public void getWinnersTest() {
        final Game game = new Game();
        List<Car> test = GenerateCar.ofCars("a,b,c");
        assertThat(game.getWinners(test)).isEqualTo("a,b,c");
    }

}
