package racingcar_step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    //테스트해야할 기능이 무엇인가?

    /*
         뭘 테스트해야할지 모르겠네.......

     */

    private RacingCar rc;

    @BeforeEach
    void init(){
        rc = new RacingCar(3, 5);
    }

    @Test
    void 입력값이_양수_인가() {
        assertThat(rc.getCarNum()).isGreaterThan(0);
        assertThat(rc.getTryNum()).isGreaterThan(0);
    }

    @Test
    void 랜덤값이_0_9_사이값인가() {
        assertThat(rc.getRandomNum())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
