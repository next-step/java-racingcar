package racingcar.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.Car;
import step3.RandomRule;

import static org.assertj.core.api.Assertions.assertThat;

class RandomRuleTest {

    private final static int position = 4;
    private RandomRule policy;

    @BeforeEach
    void setUp() {
        //given
         policy = new RandomRule();
    }

    @DisplayName("성공시 한 칸 진행, 실패시 미진행")
    @Test
    void attemptResultValidation() {
        Car car = new Car();
        int oldPosition = car.getPosition();
        boolean isMoved = policy.apply();
        if (isMoved) {
            assertThat(oldPosition).isGreaterThan(car.getPosition());
        }
        if (!isMoved) {
            assertThat(oldPosition).isLessThan(position);
        }

    }
}
