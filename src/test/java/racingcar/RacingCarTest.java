package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;
import racingcar.car.Cars;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @DisplayName("유효한 자동차 이름일 경우 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "a", " a "})
    void 자동차_입력_검증_성공(String carNames) {
        assertThatNoException()
                .isThrownBy(() -> new Cars(carNames));
    }

    @DisplayName("유효하지 않은 자동차 이름일 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,croong,honux", "pobi,,honux", "", ",,,,"})
    void 자동차_입력_검증_실패(String carNames) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Cars(carNames))
                .withMessageMatching("자동차 이름이 유효하지 않습니다");
    }

    @DisplayName("실행 횟수가 양수인 경우 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"5", "11", " 11 ", "7 "})
    void 자동차_실행_횟수_검증_성공(String count) {
        assertThatNoException()
                .isThrownBy(() -> new RacingGame(null, count));
    }

    @DisplayName("실행 횟수가 음수이거나 정수가 아닌 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"5.1", "-999", " ARA ", "1 1"})
    void 자동차_실행_횟수_검증_실패(String count) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new RacingGame(null, count))
                .withMessageMatching("실행 횟수는 양수만 가능합니다");
    }

    @DisplayName("랜덤 값이 4 이상이면 자동차는 1만큼 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 자동차_전진(int randomValue) {
        Car racingCar = new Car("pobi");
        int previousCount = racingCar.getScore();

        racingCar.move(randomValue);

        assertThat(racingCar.getScore()).isEqualTo(previousCount + 1);
    }

    @DisplayName("랜덤 값이 3 이하면 자동차는 정지한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 자동차_정지(int randomValue) {
        Car racingCar = new Car("pobi");
        int previousCount = racingCar.getScore();

        racingCar.move(randomValue);

        assertThat(racingCar.getScore()).isEqualTo(previousCount);
    }

    @Test
    void 자동자_경주_정상_동작() {
        Cars cars = new Cars("pobi,crong,honux");
        RacingGame racingGame = new RacingGame(cars, "5");

        assertThatNoException()
                .isThrownBy(() -> racingGame.play());
    }
}
