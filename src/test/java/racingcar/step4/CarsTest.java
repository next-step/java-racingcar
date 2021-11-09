package racingcar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step4.domain.Car;
import racingcar.step4.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성")
    void inputValidation1() {
        String[] arr = {"K3", "K5", "K7"};
        Cars cars = new Cars(arr);
        assertThat(cars.getCars().contains(new Car("K3"))).isTrue();
        assertThat(cars.getCars().contains(new Car("QM6"))).isFalse();
        assertThat(cars.getCars()).contains(new Car("K5"));
        assertThat(cars.getCars()).doesNotContain(new Car("K2"));
    }

    @Test
    @DisplayName("Cars 중에 가장 큰 위치 값을 찾아라")
    void getMaxPosition() {
        Car K3 = new Car("K3", 3);
        Car K5 = new Car("K5", 5);
        Car K7 = new Car("K7", 7);
        Cars cars = new Cars(K3, K5, K7);
        assertThat(cars.getMaxPosition()).isEqualTo(7);
    }

}
