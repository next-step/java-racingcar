package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinnerCarSelectorTest {

    @Test
    @DisplayName("position이 가장 높은 자동차들을 찾아야 한다")
    void getWinnerCars() {
        WinnerCarSelector winnerCarSelector = new WinnerCarSelector();

        List<Car> winnerCar = winnerCarSelector.getWinnerCars(List.of(
                new Car(3, "pobi"),
                new Car(2, "crong")));
        Assertions.assertThat(winnerCar.size()).isEqualTo(1);
        Assertions.assertThat(winnerCar.get(0).getName()).isEqualTo("pobi");

        List<Car> winnerCars = winnerCarSelector.getWinnerCars(List.of(
                new Car(1, "pobi"),
                new Car(1, "crong"),
                new Car(0, "honux")));
        Assertions.assertThat(winnerCars.size()).isEqualTo(2);
        Assertions.assertThat(winnerCars.stream().map(Car::getName)).containsAll(List.of("pobi", "crong"));
    }
}
