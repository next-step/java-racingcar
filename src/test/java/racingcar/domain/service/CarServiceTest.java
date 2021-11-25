package racingcar.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomMovingStrategyFixture;

import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTest {
    @DisplayName("move 함수는 round마다 MovingStrategy.canMove이면 position이 증가한다.")
    @ParameterizedTest
    @CsvSource(value = {"joy, 4, 3", "happy, 10, 6", "love, 20, 12", "test, 100, 60"})
    public void increaseMovementRandomly(String name, int rounds, int expectedMovement) {
        // given
        MovingStrategy strategy = new RandomMovingStrategyFixture(0);
        Car car = new Car(name);
        CarService carService = new CarService(strategy);

        // when
        for (int i = 0; i < rounds; i++) {
            car = carService.move(car);
        }

        // then
        assertThat(car.getCarPosition().getPosition()).isEqualTo(expectedMovement);
    }
}
