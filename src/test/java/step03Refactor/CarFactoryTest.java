package step03Refactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {


    @Test
    @DisplayName(",로 구분된 car 이름이 들어갔을 때 차 생성 테스트")
    void makeCar() {
        CarFactory carFactory = new CarFactory("car1, car2");
        assertThat(carFactory.getCarsSize()).isEqualTo(2);
    }

    @Test
    @DisplayName("단일 우승자 테스트")
    void getWinner() {
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 2);

        CarFactory carFactory = new CarFactory(Arrays.asList(car1, car2, car3));
        assertThat(carFactory.getWinners()).containsExactly(car2);
        assertThat(carFactory.getWinnerName()).isEqualTo("car2");
    }

    @Test
    @DisplayName("여러 우승자 테스트")
    void getWinners() {
        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 3);

        CarFactory carFactory = new CarFactory(Arrays.asList(car1, car2, car3));
        assertThat(carFactory.getWinners()).containsExactly(car2, car3);
        assertThat(carFactory.getWinnerName()).isEqualTo("car2,car3");
    }
}
