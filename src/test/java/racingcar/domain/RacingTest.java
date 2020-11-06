package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private Racing racing;
    private List<String> carNames = Arrays.asList(new String[]{"test1","test2","test3"});

    private final String RESULT_OF_RACING_WITH_A_TRY_AND_THREE_CARS_FORWARDING = "test1 : -\ntest2 : -\ntest3 : -\n\ntest1, test2, test3가 최종 우승했습니다.";
    private final String RESULT_OF_RACING_WITH_A_TRY_AND_THREE_CARS_STOPPED = "test1 : \ntest2 : \ntest3 : \n\ntest1, test2, test3가 최종 우승했습니다.";


    @BeforeEach
    void setUp(){
        racing = new Racing(carNames,1);
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
