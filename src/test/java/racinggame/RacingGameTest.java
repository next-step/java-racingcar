package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.RacingGame.racingWinner;

public class RacingGameTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("1번차", 3));
        cars.add(new Car("2번차", 5));
        cars.add(new Car("3번차", 5));
        cars.add(new Car("4번차", 4));
    }

    @DisplayName("가장 멀리간 자동차 찾기")
    @Test
    void test1() {
        List<Car> winner = racingWinner(cars);
        List<String> carName = new ArrayList<>();
        for (Car car : winner) {
            carName.add(car.getName());
        }
        assertThat(carName).containsExactly("2번차", "3번차");
    }

}
