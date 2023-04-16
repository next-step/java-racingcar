package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    @DisplayName("전진또는스톱")
    void 전진또는스톱() {
        Car car = new Car();

        // 스톱 테스트
        car.moveForwardOrStop(3);
        Assertions.assertThat(car.getMoveCount()).isEqualTo(0);

        // 전진 테스트
        car.moveForwardOrStop(4);
        Assertions.assertThat(car.getMoveCount()).isEqualTo(1);
    }

}
