package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarsTest {
    @DisplayName("생성자에 null을 넣을 수 없다.")
    @Test
    void canNotBeNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    List<String> carNames = null;
                    Cars.valueOf(carNames);
                });
    }

    @DisplayName("차를 추가할 수 있다.")
    @Test
    void addCar() {
        Cars cars = Cars.valueOf(Arrays.asList("luvram", "boram"));
        assertThat(cars.size()).isEqualTo(2);
        cars.add(new Car("rambo"));
        assertThat(cars.size()).isEqualTo(3);
    }

    @DisplayName("자동차 리스트중 가장 큰 포지션을 구한다.")
    @Test
    void maxPosition() {
        Cars cars = new Cars();
        cars.add(new Car("luvram", 3),
                new Car("boram", 2),
                new Car("rambo", 4)
        );
        assertThat(cars.getMaxPosition()).isEqualTo(4);
    }

    @DisplayName("지정한 포지션을 가진 자동차를 구한다.")
    @Test
    void getByPosition() {
        Cars cars = new Cars();
        cars.add(
                new Car("luvram", 3),
                new Car("boram", 2),
                new Car("rambo", 3)
        );

        Cars positionCars = cars.getByPosition(3);
        assertThat(positionCars.size()).isEqualTo(2);
        assertThat(positionCars.stream().map(Car::getName))
                .contains("luvram", "rambo");
    }
}
