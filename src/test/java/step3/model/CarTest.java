package step3.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_생성(){
        Car car = new Car();
        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}