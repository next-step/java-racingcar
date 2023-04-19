package carrace.domain;

import carrace.domain.Car;
import carrace.domain.CarRace;
import carrace.domain.Cars;
import carrace.domain.RandomMovable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {
    
    @Test
    @DisplayName("자동차 경주 게임을 시작할 수 있다.")
    void carTest() {
        final int numberOfLaps = 5;
        final List<String> carNames = List.of("a","b","c");
        final Cars cars = new Cars(carNames);
        final CarRace carRace = new CarRace(cars, numberOfLaps, new RandomMovable());

        carRace.start();
    }

    @Test
    @DisplayName("자동차 경주 게임의 우승자를 구할 수 있다.")
    void getWinnerTest() {
        final Car a = new Car("a", 0, 0);
        final Car b = new Car("b", 3, 1);
        final Cars cars = new Cars(a, b);
        final CarRace carRace = new CarRace(cars, 1, () -> true);

        final String winners = String.join(", ", carRace.getWinners());
        assertThat(winners).isEqualTo("b");
    }

    @Test
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.")
    void getAllWinnerTest() {
        final Car a = new Car("a", 0, 0);
        final Car b = new Car("b", 0, 1);
        final Cars cars = new Cars(a, b);
        final CarRace carRace = new CarRace(cars, 1, () -> true);

        final String winners = String.join(", ", carRace.getWinners());
        assertThat(winners).isEqualTo("a, b");
    }

}
