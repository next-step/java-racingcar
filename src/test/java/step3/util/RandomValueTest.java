package step3.util;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomValueTest {

    @RepeatedTest(10)
    void nextInt_메서드는_0부터_bound까지의_숫자를_랜덤으로_생성한다() {
        final int bound = 10;
        final int actual = RandomValue.nextInt(bound);

        assertTrue(actual >= 0 && actual < bound);
    }

}