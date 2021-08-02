package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarRacerTest {
    @Test
    void 자동차_앞으로_1칸_전진() {
        Car car = new Car(1,"JH");
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 다섯글자_초과_예외발생() {
        assertThatThrownBy(()->{
            CarRacer carRacer = new CarRacer("JJJJJK");
                }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다섯글자_정상실행() {
        CarRacer carRacer = new CarRacer("JJJJK");
    }

}