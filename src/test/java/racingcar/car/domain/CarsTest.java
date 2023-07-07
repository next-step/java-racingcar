package racingcar.car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("position 값이 가장 큰 자동차를 우승자로 선출한다.")
    void test1() {
        Cars cars = new Cars(List.of(
            new Car(3, "a"),
            new Car(4, "b"),
            new Car(5, "c")));

        List<Car> winners = cars.getWinners();

        winners.forEach(winner -> {
                assertThat(winner.matchPosition(5)).isTrue();
                assertThat(winner.getNameValue()).isEqualTo("c");
        });
    }
}
