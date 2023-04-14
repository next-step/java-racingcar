package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

    @Test
    @DisplayName("동등 판단이 가능해야 한다")
    public void equals() {
        Distance distance1 = new Distance(10);
        Distance distance2 = new Distance(10);

        assertThat(distance1).isEqualTo(distance2);

    }

    @Test
    @DisplayName("지정한 만큼만 크기가 변해야 한다")
    public void move() {
        Distance distance = new Distance(10);
        distance.move(10);

        assertThat(distance.intValue()).isEqualTo(20);
    }

    @Test
    @DisplayName("크기 비교가 가능해야 한다")
    public void compare() {
        Distance distance1 = new Distance(1);
        Distance distance2 = new Distance(2);

        assertThat(distance1).isLessThan(distance2);
    }
}