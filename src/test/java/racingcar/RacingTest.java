package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private Racing racing;

    @BeforeEach
    void setUp(){
        racing = new Racing(new String[]{"race1", "race2"});
    }

    @Test
    void chooseFinalWinners(){
        racing.runWithNoConditionAndSequence(1);
        assertThat(racing.chooseFinalWinners().size()).isEqualTo(1);
        assertThat(racing.chooseFinalWinners().get(0).whoAmI()).isEqualTo("race2");
    }


}
