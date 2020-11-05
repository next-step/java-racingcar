package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("ForwardStrategyGenerator를 주입한 상태에서의 race() 메서드 테스트")
    void raceTest_WhenGivenForwardStrategyGenerator(){
        racing.setStrategyGenerator(new ForwardStrategyGenerator());
        assertThat(racing.race()).isEqualTo(RESULT_OF_RACING_WITH_A_TRY_AND_THREE_CARS_FORWARDING);
    }

    @Test
    @DisplayName("StopStrategyGenerator를 주입한 상태에서의 race() 메서드 테스트")
    void raceTest_WhenGivenStopStrategyGenerator(){
        racing.setStrategyGenerator(new StopStrategyGenerator());
        assertThat(racing.race()).isEqualTo(RESULT_OF_RACING_WITH_A_TRY_AND_THREE_CARS_STOPPED);
    }
}
