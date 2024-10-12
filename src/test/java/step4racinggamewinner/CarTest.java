package step4racinggamewinner;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 차이름5글자_초과실패() {
        Car car = new Car("redeee");
        assertThatThrownBy(() -> {
                    car.checkNameLength();
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }


}
