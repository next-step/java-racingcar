package study.step4.try2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void 자동차_생성수_파악하기() {
        Car car1 = new Car("pobi", Position.of(0));
        Car car2 = new Car("java", Position.of(0));
        Car car3 = new Car("jigi", Position.of(0));
        Cars cars = Cars.of(Arrays.asList(car1, car2, car3));
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void 자동차객체_리스트_중_가장_큰값_구하기() {
        Car car1 = new Car("pobi", Position.of(5));
        Car car2 = new Car("java", Position.of(4));
        Car car3 = new Car("jigi", Position.of(3));
        Cars cars = Cars.of(Arrays.asList(car1, car2, car3));
        assertThat(cars.getMaxTest(cars)).isEqualTo(5);
    }

    @Test
    void 자동차경주게임_우승자_구하기() {
        Car car1 = new Car("pobi", Position.of(5));
        Car car2 = new Car("java", Position.of(4));
        Car car3 = new Car("jigi", Position.of(3));
        Cars cars = Cars.of(Arrays.asList(car1, car2, car3));
        assertThat(cars.getWinnersTest(cars)).isEqualTo("pobi");
    }
}