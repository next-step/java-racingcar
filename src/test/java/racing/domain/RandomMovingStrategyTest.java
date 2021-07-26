package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.utils.RandomNumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomMovingStrategyTest {

    @DisplayName("Random값이 THRESHOLD_NUMBER의 4보다 작으면 false를 반환한다")
    @Test
    void downThresHoldNumberTest() {
        //given
        RandomNumber randomNumber = new RandomNumberTestDownThresholdNumber();

        //when
        MovingStrategy strategy = new RandomMovingStrategy(randomNumber);

        //then
        assertFalse(strategy.isMove());
    }

    @DisplayName("Random값이 THRESHOLD_NUMBER의 4보다 크면 true를 반환한다")
    @Test
    void upThresHoldNumberTest() {
        //given
        RandomNumber randomNumber = new RandomNumberTestUpThresholdNumber();

        //when
        MovingStrategy strategy = new RandomMovingStrategy(randomNumber);

        //then
        assertTrue(strategy.isMove());
    }

    private static class RandomNumberTestUpThresholdNumber extends RandomNumber {
        @Override
        public int create() {
            return 6;
        }
    }

    private static class RandomNumberTestDownThresholdNumber extends RandomNumber {
        @Override
        public int create() {
            return 3;
        }
    }
}