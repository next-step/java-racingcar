package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setup() {
        car = new Car("A", 0);
    }

    @DisplayName("자동차 전진은 입력된 값이 4이상의 경우 position에 1만큼 더해 준다.")
    @Test
    void 자동차_전진_성공_테스트() {
        //when
        car.move(4);
        int result = car.getPosition();

        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("자동차 전진은 입력된 값이 3이하의 경우 position 변경이 없다.")
    @Test
    void 자동차_전진_불가_테스트() {
        //when
        car.move(3);
        int result = car.getPosition();

        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("자동차 전진은 입력된 값이 음수인 경우 오류가 발생된다.")
    @Test
    void 자동차_전진_오류_테스트() {
        assertThrows(IllegalArgumentException.class, () -> car.move(-1));
    }
}
