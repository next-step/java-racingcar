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

    @BeforeEach
    void setUp(){
        car = new Car(TEST_NAME);
    }

    @Test
    @DisplayName("ForwardStrategy 전략 하에서의 Car의 move() 테스트")
    void moveTest_whenGivenForwardStrategy(){
        int before = car.getNumberOfMoves();
        car.move(forwardStrategy);
        assertThat(car.getNumberOfMoves()).isEqualTo(before + 1);
    }

    @Test
    @DisplayName("StopStrategy 전략 하에서의 Car의 move() 테스트")
    void moveTest_whenGivenStopStrategy(){
        int before = car.getNumberOfMoves();
        car.move(stopStrategy);
        assertThat(car.getNumberOfMoves()).isEqualTo(before);
    }
}
