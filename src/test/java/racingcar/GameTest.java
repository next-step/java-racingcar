package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.Game;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTest {

    @Test
    @DisplayName("getWinners 테스트")
    public void getWinnersTest() {
        final Game game = new Game();
        final ArrayList<String> cars= new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<Car> test = CarGenerator.generateCars(cars);
        assertThat(game.getWinners(test)).isEqualTo("a,b,c");
    }

}
