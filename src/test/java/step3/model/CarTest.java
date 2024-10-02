package step3.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_생성(){
        String carName = "hwan2";
        Car car = new Car(carName);
        assertThat(car.getMovement()).isEqualTo(0);
    }
}