package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.CarController;
import racingcar.random.TestRandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    private CarController carController;

    @DisplayName("init에서 입력 값으로 들어온 갯수만큼 자동차를 만들 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void init(int numberOfCar) {
        // given
        TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(0);
        CarController carController = new CarController(testRandomNumberGenerator);
        Round round = new Round(carController);

        // when
        round.init(numberOfCar);

        // then
        assertThat(round.getCars())
                .hasSize(numberOfCar);
    }

    @DisplayName("난수가 4이상이면 2대의 자동차가 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 9, 100})
    void moveCars(int randomNumber) {
        // given
        TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(randomNumber);
        CarController carController = new CarController(testRandomNumberGenerator);
        Round round = new Round(carController);
        round.init(2);

        // when
        round.start();

        // then
        assertThat(round.getCars())
                .extracting("position")
                .containsExactly(1, 1);
    }

    @DisplayName("난수가 4미만이면 2대의 자동차가 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void noMoveCars(int randomNumber) {
        // given
        TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(randomNumber);

        CarController carController = new CarController(testRandomNumberGenerator);
        Round round = new Round(carController);
        round.init(2);

        // when
        round.start();

        // then
        assertThat(round.getCars())
                .extracting("position")
                .containsExactly(0, 0);
    }
}
