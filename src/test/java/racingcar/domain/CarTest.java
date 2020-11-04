package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    private final String JOIN_DELIMITER = "";
    private final String COPY_DELIMITER = "-";
    private final String NEW_LINE_DELIMITER = "\n";

    @BeforeEach
    void setUp(){
        car = new Car();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void moveTest_whenGivenSatisfyingRandomNumbers(int randomNumber){
        assertThat(car.move(randomNumber)).isEqualTo(COPY_DELIMITER.concat(NEW_LINE_DELIMITER));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void moveTest_whenGivenUnatisfyingRandomNumbers(int randomNumber){
        assertThat(car.move(randomNumber)).isEqualTo(JOIN_DELIMITER.concat(NEW_LINE_DELIMITER));
    }
}
