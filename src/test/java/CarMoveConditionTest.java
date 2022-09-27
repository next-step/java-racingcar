import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarMoveConditionTest {

    @ParameterizedTest
    @CsvSource(value = {"0:3:false", "4:9:true"}, delimiter = ':')
    void carMoveTest(int startGiven, int endGiven, boolean expected) {
        CarMoveCondition carMoveCondition = new CarMoveCondition();

        for(int given = startGiven; given <= endGiven; given++){
            assertThat(carMoveCondition.checkMoveCondition(given)).isEqualTo(expected);
        }
    }

    @Test
    void carMoveFailedTest() {
        assertThatThrownBy(() -> new CarMoveCondition().checkMoveCondition(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("not available value");
    }
}
