package racingcar.service.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.strategy.Rule;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car testCar;

    @BeforeEach
    void setup() {
        testCar = new Car(1);
    }

    @Test
    @DisplayName("조건이 맞는 경우 position 증가 검증")
    void increasePosition() {
        for (int i = 1; i < 10; i++) {
            testCar.move(new TrueRule());
            assertThat(testCar.getPosition()).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("조건이 맞지 않는 경우 position 유지 검증")
    void samePosition() {
        for (int i = 0; i < 10; i++) {
            testCar.move(new FalseRule());
            assertThat(testCar.getPosition()).isZero();
        }
    }

    static class TrueRule implements Rule {
        @Override
        public boolean checkCondition() {
            return true;
        }
    }

    static class FalseRule implements Rule {
        @Override
        public boolean checkCondition() {
            return false;
        }
    }
}
