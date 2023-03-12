package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingRandom;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingRandomTest {
    @Test
    void randomizeTenBegger(){
        for(int i=0;i<5000;i++){
            assertThat(RacingRandom.randomizeTenBegger())
                    .isGreaterThan(-1)
                    .isLessThan(10);
        }
    }

}
