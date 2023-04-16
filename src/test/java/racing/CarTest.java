package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("자동차 이름을 5자 이상 작성할 시 예외를 던진다")
    void test1(){
        Car car = new Car();

        assertThatThrownBy(()-> car.exceptionCarNameCount(car))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없다");
    }

}