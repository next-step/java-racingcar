package race;

import org.junit.jupiter.api.BeforeEach;
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
    RacingModel racingModel = new RacingModel();

    @BeforeEach
    void setting() {
        racingModel.prepareRacing(3, 5);
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


}
