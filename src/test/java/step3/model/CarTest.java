package step3.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_생성(){
        Car car = new Car();
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 랜덤숫자가_4이상일경우_전진한다(){
        Car car = new Car();
        car.move(4);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    void 랜덤숫자가_4미만일경우_전진안한다(){
        Car car = new Car();
        car.move(3);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}