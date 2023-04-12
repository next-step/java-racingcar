package racingcar;

import org.junit.jupiter.api.Test;

class RacingTest {
    @Test
    void racing_한대_시도한번() {
        Racing racing = new Racing(1,1);
        racing.excute();
    }

    @Test
    void racing_한대_시도두번() {
        Racing racing = new Racing(1,2);
        racing.excute();
    }

    @Test
    void racing_여러대_시도여러번() {
        Racing racing = new Racing(3,3);
        racing.excute();
    }

}