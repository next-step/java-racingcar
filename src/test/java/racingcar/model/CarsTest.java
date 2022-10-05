package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("게임 우승자가 1명의 경우 검증")
    public void find_winner() {
        Cars cars = new Cars(List.of(
                new Car(4, "bella"),
                new Car(3, "demi")
        ));

        List<Car> result = cars.findWinner();

        List<Car> expected = List.of(new Car(4, "bella"));

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("게임 우승자가 여러 명의 경우 검증")
    public void find_winners() {
        Cars cars = new Cars(List.of(
                new Car(4, "bella"),
                new Car(4, "demi"),
                new Car(2, "tina")
        ));

        List<Car> result = cars.findWinner();

        List<Car> expected = List.of(
                new Car(4, "bella"),
                new Car(4, "demi")
        );

        assertThat(result).isEqualTo(expected);
    }
}