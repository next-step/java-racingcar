package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 전진 유무 체크")
    void moveOfCar() {
        Car car = new Car("car");
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("차량 객체 생성 테스트 코드")
    void registerCars() {
        Cars cars = new Cars("a,b,c");
        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}
