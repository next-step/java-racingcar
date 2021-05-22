package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car = new Car("ssung",0);

    @Test
    @DisplayName("car 객체 생성 테스트")
    void carTest() {
        // given
        String name = car.getName();
        int position = car.getPosition();

        // then
        assertThat(name).isEqualTo("ssung");
        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("go 객체 테스트")
    void goTest() {
        // given
        car.go();
        int position = car.getPosition();

        // then
        assertThat(position).isEqualTo(1);
    }
}
