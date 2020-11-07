package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.Constants;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    private MoveStrategy forwardStrategy = new ForwardStrategy();;
    private MoveStrategy stopStrategy = new StopStrategy();

    private final String TEST_NAME = "test";


    private final String RESULT_OF_A_FORWARD_CAR = TEST_NAME.concat(Constants.WHITE_SPACE_DELIMITER)
            .concat(Constants.COLON_DELIMITER)
            .concat(Constants.WHITE_SPACE_DELIMITER)
            .concat(Constants.HYPHEN_DELIMITER)
            .concat(Constants.NEW_LINE_DELIMITER);

    private final String RESULT_OF_A_STOPPED_CAR = TEST_NAME.concat(Constants.WHITE_SPACE_DELIMITER)
            .concat(Constants.COLON_DELIMITER)
            .concat(Constants.WHITE_SPACE_DELIMITER)
            .concat(Constants.BLANK_DELIMITER)
            .concat(Constants.NEW_LINE_DELIMITER);


    @BeforeEach
    void setUp(){
        car = new Car(TEST_NAME);
    }

    @Test
    @DisplayName("ForwardStrategy 전략 하에서의 Car의 move() 테스트")
    void moveTest_whenGivenForwardStrategy(){
        assertThat(car.move(forwardStrategy)).isEqualTo(RESULT_OF_A_FORWARD_CAR);
    }

    @Test
    @DisplayName("StopStrategy 전략 하에서의 Car의 move() 테스트")
    void moveTest_whenGivenStopStrategy(){
        assertThat(car.move(stopStrategy)).isEqualTo(RESULT_OF_A_STOPPED_CAR);
    }
}
