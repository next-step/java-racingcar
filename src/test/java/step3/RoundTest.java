package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.car.Car;
import step3.car.CarController;
import step3.random.TestRandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @DisplayName("난수가 4이상이면 2대의 자동차가 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 9, 100})
    void moveCars(int randomNumber) {
        // given
        TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(randomNumber);

        CarController carController = new CarController(testRandomNumberGenerator);
        List<Car> cars = List.of(new Car(), new Car());
        Round round = new Round(cars, carController);

        // when
        round.start();

        // then
        assertThat(round.getCars())
                .extracting("position")
                .containsExactly(randomNumber, randomNumber);
    }

    @DisplayName("난수가 4미만이면 2대의 자동차가 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void noMoveCars(int randomNumber) {
        // given
        TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(randomNumber);

        CarController carController = new CarController(testRandomNumberGenerator);
        List<Car> cars = List.of(new Car(), new Car());
        Round round = new Round(cars, carController);

        // when
        round.start();

        // then
        assertThat(round.getCars())
                .extracting("position")
                .containsExactly(0, 0);
    }
}
