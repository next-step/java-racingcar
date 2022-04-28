package study.step5.try3.domain;

import org.junit.jupiter.api.Test;
import study.step5.try3.domain.Car;
import study.step5.try3.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void 자동차_생성수_파악하기() {
        Car car1 = new Car("pobi", 0);
        Car car2 = new Car("java", 0);
        Car car3 = new Car("jigi", 0);
        Cars cars = Cars.of(Arrays.asList(car1, car2, car3));
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void 자동차객체_리스트_중_가장_큰값_구하기() {
        Car car1 = new Car("pobi", 5);
        Car car2 = new Car("java", 4);
        Car car3 = new Car("jigi", 3);
        Cars cars = Cars.of(Arrays.asList(car1, car2, car3));
        assertThat(cars.getMax()).isEqualTo(5);
    }

    @Test
    void 자동차경주게임_우승자_구하기() {
        Car car1 = new Car("pobi", 5);
        Car car2 = new Car("java", 4);
        Car car3 = new Car("jigi", 3);
        Cars cars = Cars.of(Arrays.asList(car1, car2, car3));
        assertThat(cars.getWinners()).isEqualTo("pobi");
    }
}