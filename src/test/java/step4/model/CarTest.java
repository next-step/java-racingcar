package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @DisplayName("자동차 이름 추가")
    @Test
    void setCarName(){
        String name = "first_car";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }
}