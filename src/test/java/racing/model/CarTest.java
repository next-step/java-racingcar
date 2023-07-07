package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.IllegalCarNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @DisplayName("자동차 생성 성공 테스트")
    @Test
    void newCarTest() {
        assertDoesNotThrow(() -> new Car("pobi"));
    }

    @DisplayName("자동차 생성 실패 테스트")
    @Test
    void newCarFailTest() {
        assertThrows(IllegalCarNameException.class, () -> new Car(""));
        assertThrows(IllegalCarNameException.class, () -> new Car("123456"));
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    void goForwardTest() {
        //given
        Car car = new Car("pobi");

        //when
        car.goForward();

        //then
        assertThat(car.isPositionValue(2)).isTrue();
    }
}
