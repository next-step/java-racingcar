package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.strategy.RandomMoveStrategyTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("랜덤숫자가 4이상일 때 전진 확인")
    void car_전진확인() {
        Car car = new Car( "a");
        car.moveForward(4);
        assertThat(car.forwardCnt()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤숫자가 4미만일 때 정지 확인")
    void car_정지확인() {
        Car car = new Car( "a");
        car.moveForward(0);
        assertThat(car.forwardCnt()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤숫자가 4미만일 때 정지 확인")
    void car_자동차이름확인(){
        Car car = new Car( "a");
        assertThat(car.carName()).isEqualTo("a");
    }
}
