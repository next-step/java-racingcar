package racing.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.behavior.CarMovable;
import racing.domain.Car;
import racing.domain.RacingCars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(
                new Car("jace", new CarMovable()),
                new Car("mia", new CarMovable()),
                new Car("noel", new CarMovable())
        );

        cars.get(0).move();
    }

    @DisplayName("자동차 이동 표시 확인 테스트")
    @Test
    void printLocationByCar() {
        cars.get(0).move();

        assertThat(ResultView.printLocationByCar(cars.get(0))).isEqualTo("-");
        assertThat(ResultView.printLocationByCar(cars.get(1))).isEqualTo("");
        assertThat(ResultView.printLocationByCar(cars.get(2))).isEqualTo("");
    }

    @DisplayName("최종 우승자 결과 확인 테스트")
    @Test
    void printRacingWinners() {
        final RacingCars racingCars = new RacingCars(cars);

        assertThat(ResultView.toStringRacingWinners(racingCars)).contains("jace");
    }
}
