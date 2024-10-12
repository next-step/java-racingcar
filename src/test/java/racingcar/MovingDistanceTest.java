package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.race.Car;
import racingcar.model.race.MovingDistance;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingDistanceTest {

    @Test
    @DisplayName("isCarMoved 변수가 true 이면 이동, false 이면 정지")
    public void increase() {
        MovingDistance movingDistance = new MovingDistance(1);

        movingDistance.increase(true);
        assertThat(movingDistance.getValue()).isEqualTo(2);

        movingDistance.increase(false);
        assertThat(movingDistance.getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차들의 최대 이동거리와 현재 자동차의 이동거리가 같은지 비교하는 메서드 테스트")
    public void isSame() {
        Car car = new Car("kb", 3);
        assertThat(car.isSame(3)).isTrue();
        assertThat(car.isSame(5)).isFalse();
    }

    @Test
    @DisplayName("자동차들중 최대 이동거리를 구하는 메서드 테스트")
    public void isLongest() {
        MovingDistance movingDistance = new MovingDistance(2);
        assertThat(movingDistance.longest(1)).isEqualTo(2);
    }
}
