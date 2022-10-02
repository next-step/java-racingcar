package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {
    Position positions;
    Car car;
    Racing racing;
    OutputResult outputResult;

    @BeforeEach
    void init() {
        String[] names = new String[]{"test1","test2"};
        positions = new Position();
        positions.initPosition(new ArrayList<>(List.of(names)));

        car = new Car(names, 3);

        racing = new Racing();
        outputResult = new OutputResult();

    }

    @Test
    void getRandomNum() {
        assertThat(racing.getRandomNum()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:true", "3:false"}, delimiter = ':')
    void isSatisfiedConditionForMoveTest(int number, boolean result) {
        assertThat(racing.isSatisfiedConditionForMove(number)).isEqualTo(result);
    }

    @Test
    void test() {
        racing.racing(positions, car, outputResult);
    }
}
