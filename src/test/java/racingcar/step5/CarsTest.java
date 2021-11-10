package racingcar.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step5.domain.Car;
import racingcar.step5.domain.Cars;
import racingcar.step5.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성")
    void inputValidation1() {
        Cars cars = new Cars("K3, K5, K7");
        assertThat(cars.getCars().contains(new Car("K3"))).isTrue();
        assertThat(cars.getCars().contains(new Car("QM6"))).isFalse();
        assertThat(cars.getCars()).contains(new Car("K5"));
        assertThat(cars.getCars()).doesNotContain(new Car("K2"));
    }

    @Test
    @DisplayName("자동차 이름을 구분자로 쪼개기")
    void nameSplit() {
        Cars cars = new Cars("k3,k5");
        System.out.println(cars.getCars());
        assertThat(cars.getCars()).contains(new Car("k3"));
        assertThat(cars.getCars()).contains(new Car("k5"));
        // 빈값 들어올 경우 에러
        assertThatThrownBy(() -> new Cars("k3, k5, "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Cars 중에 가장 큰 위치 값을 찾아라")
    void getMaxPosition() {
        Car K3 = new Car("K3", 3);
        Car K5 = new Car("K5", 5);
        Car K7 = new Car("K7", 7);
        Cars cars = new Cars(K3, K5, K7);
        assertThat(cars.getMaxPosition()).isEqualTo(new Position(7));
    }

}
