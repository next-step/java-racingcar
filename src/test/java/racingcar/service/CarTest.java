package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차 움직임 테스트")
    void move()
    {
        String name = "pobi";

        Car car = new Car(name);
        assertThat(car.drive()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름 테스트")
    void validateName() {
        String name = "crong";
        Car car = new Car(name);
        
        assertThat(car.getName()).isEqualTo(name);
    }
    @Test
    @DisplayName("자동차 이름이 5글자 초과 시")
    void validateWithNameLengthOver5() {
        assertThatThrownBy(()-> { Car car = new Car("crongv"); })
                .isInstanceOf(RuntimeException.class).hasMessageContaining("over 5 length");
    }

}
