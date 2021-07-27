package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.RacingGame;
import racing.model.Car;
import racing.model.Racing;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {

    RacingGame racingGame = new RacingGame();
    Racing racing = new Racing();
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setting() {
        racing.prepareRacing("pobi,test1,test2", 5);
        racingGame.game(racing,1);
        cars = racing.participants().carList();
    }


    @Test
    @DisplayName("move condition test")
    void randomValueTest() {
        assertThatThrownBy(() -> {
            racingGame.moveCondition(10);
        }).isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @DisplayName("game end test")
    @CsvSource(value = {"3:false", "5:true"}, delimiter = ':')
    void gameEndTest(int input, boolean expected) {
       assertThat(racingGame.game(racing, input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:false", "5:true"}, delimiter = ':')
    @DisplayName("car move Test")
    void carMoveTest(int randomValue, boolean expected) {
        assertThat(racingGame.run(cars.get(0), randomValue)).isEqualTo(expected);
    }

}
