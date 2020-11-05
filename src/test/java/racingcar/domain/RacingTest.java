package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private Racing racing;
    private final String RESULT_OF_RACING_WITH_A_TRY_AND_THREE_CARS_FORWARDING = "-\n-\n-\n\n";
    private final String RESULT_OF_RACING_WITH_A_TRY_AND_THREE_CARS_STOPPED = "\n\n\n\n";


    @BeforeEach
    void setUp(){
        racing = new Racing(3,1);
    }

    @Test
    void raceTest_WhenGivenForwardStrategyGenerator(){
        racing.setStrategyGenerator(new ForwardStrategyGenerator());
        assertThat(racing.race()).isEqualTo(RESULT_OF_RACING_WITH_A_TRY_AND_THREE_CARS_FORWARDING);
    }

    @Test
    void raceTest_WhenGivenStopStrategyGenerator(){
        racing.setStrategyGenerator(new StopStrategyGenerator());
        assertThat(racing.race()).isEqualTo(RESULT_OF_RACING_WITH_A_TRY_AND_THREE_CARS_STOPPED);
    }

}
