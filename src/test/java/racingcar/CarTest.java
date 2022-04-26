package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RandomStrategy;


import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car = new Car("jisu");

    @Test
    @DisplayName("랜덤 전략을 사용한 자동차 전진 테스트")
    void moveTest() {
        car.moveOrStop(new RandomStrategy() {
            @Override
            public boolean checkCondition() {
                return true;
            }
        });
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 전략을 사용한 자동차 멈춤 테스트")
    void stopTest() {
        car.moveOrStop(new RandomStrategy() {
            @Override
            public boolean checkCondition() {
                return false;
            }
        });
        assertThat(car.getPosition()).isZero();
    }

}
