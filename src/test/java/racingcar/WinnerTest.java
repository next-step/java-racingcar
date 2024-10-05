package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {
    @Test
    @DisplayName("우승자를 가져오는지 확인")
    void getWinners() {
        RacingGame.cars = new ArrayList<>();
        Car car1 = new Car("thanker");
        Car car2 = new Car("pobi");
        RacingGame.cars.add(car1);
        RacingGame.cars.add(car2);

        car1.move(true);
        car2.move(false);

        List<Car> winners = Winner.getWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners).extracting(Car::getName)
                           .containsExactly("thanker");
    }

    @Test
    @DisplayName("우승자 여러명을 가져오는지 확인")
    void getWinners_여러명() {
        RacingGame.cars = new ArrayList<>();
        Car car1 = new Car("thanker");
        Car car2 = new Car("pobi");
        Car car3 = new Car("crong");
        RacingGame.cars.add(car1);
        RacingGame.cars.add(car2);
        RacingGame.cars.add(car3);

        car1.move(true);
        car2.move(true);
        car3.move(false);

        List<Car> winners = Winner.getWinners();
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getName)
                           .containsExactlyInAnyOrder("thanker", "pobi");
    }
}
