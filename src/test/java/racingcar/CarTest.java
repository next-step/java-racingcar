package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("Car 생성자 테스트")
    public void createCarTest() {
        // given
        Car car = new Car("tomas",0);

        // then
        assertThat(car.getName()).isEqualTo("tomas");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
