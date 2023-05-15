package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @DisplayName("가장 멀리간 자동차 찾기")
    @Test
    void findWinner() {
        AlwaysMoveForward alwaysMoveForward = new AlwaysMoveForward();
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("1번차");
        car1.move(alwaysMoveForward);
        car1.move(alwaysMoveForward);
        cars.add(car1);

        Car car2 = new Car("2번차");
        car2.move(alwaysMoveForward);
        cars.add(car2);

        WinnersCar winnersCar = new WinnersCar(cars);

        List<String> carName = new ArrayList<>();
        for (Car car : winnersCar.winners()) {
            carName.add(car.getName());
        }
        assertThat(carName).containsExactly("1번차");
    }

}
