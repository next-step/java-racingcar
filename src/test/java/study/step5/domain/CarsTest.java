package study.step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("차량 5대 등록")
    @ParameterizedTest
    @CsvSource(value = {"자동차1호,자동차2호,자동차3호,자동차4호,자동차5:5"}, delimiter = ':')
    void of(String carNames, int expected) {
        Cars cars = Cars.of(carNames.split(","));
        assertThat(cars.getSize()).isEqualTo(expected);
    }

    @DisplayName("차량 이동 결과 일치하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"자동차1호:1:1", "자동차1호,자동차2호:4:4", "자동차1호,자동차2호,자동차3호:5:5"}, delimiter = ':')
    void move(String carNames, int moveIndex, int expected) {
        MoveBehavior moveBehavior = new OneLocationMoveBehavior();
        Cars cars = Cars.of(carNames.split(","));

        while (moveIndex-- > 0) {
            cars.move(moveBehavior);
        }

        assertThat(cars.stream()
                    .map(car -> car.getLocation())
                    .findFirst()
                    .orElse(0))
                .isEqualTo(expected);
    }

    @DisplayName("레이싱게임의 우승자 확인")
    @Test
    void checkWinner() {
        List<Car> carList = new ArrayList<>();
        Car car1 = Car.of("hwang");
        Car car2 = Car.of("lee");
        Car car3 = Car.of("kim");
        car1.move(5);
        car2.move(4);
        car3.move(10);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = Cars.of(carList);

        assertThat(cars.getWinners().get(0).getCarName()).isEqualTo("kim");
    }
}
