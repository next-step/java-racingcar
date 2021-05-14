package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarTest {

    @DisplayName("0~9사이의 무작위 값을 뽑아 4이상이면 자동차를 움직일 수 있다")
    @Test
    void isMoveTest() {
        Car car = new Car("poby");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
