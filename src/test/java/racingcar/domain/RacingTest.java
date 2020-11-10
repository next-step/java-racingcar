package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    private Racing racing;
    private List<String> carNames = Arrays.asList(new String[]{"test1","test2","test3"});

    @BeforeEach
    void setUp(){
        racing = new Racing(carNames,1);
    }

    @Test
    @DisplayName("ForwardStrategyGenerator를 주입한 상태에서의 race() 메서드 테스트")
    void raceTest_WhenGivenForwardStrategyGenerator(){
        racing.setStrategyGenerator(new ForwardStrategyGenerator());
        racing.race();
        assertThat(racing.getRacingResult().getWinners().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("StopStrategyGenerator를 주입한 상태에서의 race() 메서드 테스트")
    void raceTest_WhenGivenStopStrategyGenerator(){
        racing.setStrategyGenerator(new StopStrategyGenerator());
        racing.race();
        assertThat(racing.getRacingResult().getWinners().size()).isEqualTo(3);
    }
}
