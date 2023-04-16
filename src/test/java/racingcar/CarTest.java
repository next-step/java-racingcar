package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("전진또는스톱")
    void 전진또는스톱() {
        Car car = new Car();

        int moveCount = car.getMoveCount();

        // 스톱 테스트
        car.moveForwardOrStop(3);
        Assertions.assertThat(car.getMoveCount()).isEqualTo(moveCount);

        // 전진 테스트
        car.moveForwardOrStop(4);
        Assertions.assertThat(car.getMoveCount()).isEqualTo(moveCount + 1);
    }

}
