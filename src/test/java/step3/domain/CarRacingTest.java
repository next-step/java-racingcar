package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarRacingTest {

    @DisplayName("세대의 자동차를 1회 경주하면 출발위치가 가장 큰 자동차가 우승한다.")
    @Test
    public void start() {
        int roundCount = 1;

        Car test1 = new Car("test1", 3);
        Car test2 = new Car("test2", 5);
        Car test3 = new Car("test3", 7);

        List<Car> cars = new ArrayList<>();
        cars.add(test1);
        cars.add(test2);
        cars.add(test3);

        CarRacing carRacing = new CarRacing(new Cars(cars), new Round(roundCount));
        CarRacingResult carRacingResult = carRacing.start();

        assertThat(carRacingResult
                .getWinner()
                .findWinnerCarNames())
                .containsExactly("test3");
    }
}
