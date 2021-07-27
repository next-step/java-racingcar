package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.Racing;
import racing.model.CarModel;
import racing.model.CarsModel;
import racing.model.RacingModel;
import racing.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {

    Racing racing = new Racing();
    RacingModel racingModel = new RacingModel();
    List<CarModel> cars = new ArrayList<>();

    @BeforeEach
    void setting() {
        racingModel.prepareRacing(3, 5);
        racing.game(racingModel,1);
        cars = racingModel.participants().carList();
    }


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
       assertThat(racing.game(racingModel, input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:false", "5:true"}, delimiter = ':')
    @DisplayName("car move Test")
    void carMoveTest(int randomValue, boolean expected) {
        assertThat(racing.carMove(cars.get(0), randomValue)).isEqualTo(expected);
    }

}
