package racing.car;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarFactoryTest {

    @Test
    void 주어진_횟수만큼_자동차생성() {
        String carName = "BMW, AUDI";
        List<Car> list = CarFactory.generateCars(carName);
        assertThat(list).hasSize(2);
    }

    @Test
    void 자동차_이름_5자초과() {
        String carName = "ss, bbbbbb";
        assertThatThrownBy(() -> CarFactory.generateCars(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_2대이상() {
        String carName = "ss";
        assertThatThrownBy(() -> CarFactory.generateCars(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}
