package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.Racing;
import racing.model.CarModel;
import racing.model.RacingModel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {
    Racing racing = new Racing();


    @Test
    @DisplayName("move condition test")
    void randomValueTest() {
        assertThatThrownBy(() -> {
            racing.moveCondition(10);
        }).isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @DisplayName("game end test")
    @CsvSource(value = {"3:false", "5:true"}, delimiter = ':')
    void gameEndTest(int input, boolean expected) {
       RacingModel racingModel = new RacingModel();
       racingModel.prepareGame(3, 5);

       assertThat(racing.game(racingModel, input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("car distance check Test")
    void carDistanceCheckTest() {
        CarModel car = new CarModel();
        car.go();
        assertThat(car.totalDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:false", "5:true"}, delimiter = ':')
    @DisplayName("car move Test")
    void carMoveTest(int randomValue, boolean expected) {
        CarModel car = new CarModel();
        assertThat(racing.carMove(car, randomValue)).isEqualTo(expected);
    }
}
