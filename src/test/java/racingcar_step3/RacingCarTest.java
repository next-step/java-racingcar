package racingcar_step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private Racing rc;

    @BeforeEach
    void init(){
        rc = new Racing();
    }

    @Test
    void 입력값이_양수_인가() {
        assertThat(rc.getCarNum()).isGreaterThan(0);
        assertThat(rc.getTryNum()).isGreaterThan(0);
    }

}
