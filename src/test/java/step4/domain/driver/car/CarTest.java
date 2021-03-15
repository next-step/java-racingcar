package step4.domain.driver.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final String UNIT = "-";

    @DisplayName("Car 클래스의 move()에 true 값이 주어졌을 때 값이 증가되는지 테스트")
    @RepeatedTest(value = 10, name = "현재 Loop : {0}")
    void move_ValidationValue_EqualUNIT() {
        // given
        Car car = Car.newInstance();

        // when
        car.move(() -> true);
        String actual = car.toString();

        // then
        assertThat(actual).isEqualTo(UNIT);
    }

}