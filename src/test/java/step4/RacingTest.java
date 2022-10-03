package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.*;

public class RacingTest {
    Car car;
    Racing racing;
    OutputResult outputResult;

    @BeforeEach
    void init() {
        racing = new Racing();
        outputResult = new OutputResult();
    }

    @Test
    void getRandomNumTest() {
        assertThat(racing.getRandomNum()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:true", "3:false"}, delimiter = ':')
    void isSatisfiedConditionForMoveTest(int number, boolean result) {
        assertThat(racing.isSatisfiedConditionForMove(number)).isEqualTo(result);
    }

    @Test
    void racingTest() {
        Car[] cars = new Car[3];
        cars[0] = new Car("test0", new Position());
        cars[1] = new Car("test1", new Position());
        cars[2] = new Car("test2", new Position());

        racing.racing(cars, 3);
    }
}
