package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.model.Car;
import step4.model.Winners;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    @DisplayName("레이싱이 완료 된 자동차 리스트를 받아 우승자를 정한다.")
    void getWinnersTest() {
        Car carJane = new Car("jane");
        Car carJohn = new Car("john");

        carJane.go(4);
        carJohn.go(3);

        List<Car> winners = new Winners(List.of(carJane, carJohn)).get();
        assertThat(winners.stream().map(Car::getName).collect(Collectors.joining()))
                .isEqualTo("jane");

    }

    @Test
    @DisplayName("레이싱이 완료 된 자동차 리스트를 받아 우승자가 2명 이상이라면 두명 다 조회된다.")
    void getMultipleWinnersTest() {
        Car carJane = new Car("jane");
        Car carJohn = new Car("john");

        carJane.go(4);
        carJohn.go(5);

        List<Car> winners = new Winners(List.of(carJane, carJohn)).get();
        assertThat(winners.stream().map(Car::getName).collect(Collectors.joining(",")))
                .isEqualTo("jane,john");

    }
}
