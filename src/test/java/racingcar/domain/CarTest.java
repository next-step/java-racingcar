package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    private MoveStrategy forwardStrategy = new ForwardStrategy();;
    private MoveStrategy stopStrategy = new StopStrategy();;
    private final String JOIN_DELIMITER = "";
    private final String COPY_DELIMITER = "-";
    private final String NEW_LINE_DELIMITER = "\n";

    @BeforeEach
    void setUp(){
        car = new Car();
    }

    @Test
    @DisplayName("ForwardStrategy 전략 하에서의 Car의 move() 테스트")
    void moveTest_whenGivenForwardStrategy(){
        assertThat(car.move(forwardStrategy)).isEqualTo(COPY_DELIMITER.concat(NEW_LINE_DELIMITER));
    }

    @Test
    @DisplayName("StopStrategy 전략 하에서의 Car의 move() 테스트")
    void moveTest_whenGivenStopStrategy(){
        assertThat(car.move(stopStrategy)).isEqualTo(JOIN_DELIMITER.concat(NEW_LINE_DELIMITER));
    }
}
