package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    //given
    Car car = new Car();

    @Test
    @DisplayName("(1)자동차의 위치를 전달")
    public void position() {
        //when, then
        Assertions.assertThat(car.position()).isEqualTo(0);
    }

    @Test
    @DisplayName("(2)자동차의 위치를 업데이트")
    public void updatePosition() {
        //when
        car.updatePosition();

        //then (Car Class's Random seed: 54321)
        Assertions.assertThat(car.position()).isEqualTo(1);
    }
}
