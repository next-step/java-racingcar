package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차의 이동 횟수가 랜덤한 확률로 증가한다")
    public void moveCarIncreaseMovingCountByRandom() {
        Car car = new Car();

        car.move();

        assertThat(car.getMoveCount()).isEqualTo(1);
    }
}
