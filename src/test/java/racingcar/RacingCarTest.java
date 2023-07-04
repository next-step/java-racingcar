package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {

    @DisplayName("유효한 자동차 이름일 경우 true를 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "a", " a "})
    void 자동차_입력_검증_성공(String carNames) {
        assertThat(RacingCar.isValidCarNames(carNames))
                .isEqualTo(true);
    }

    @DisplayName("유효하지 않은 자동차 이름일 경우 false를 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,croong,honux", "pobi,,honux", ",,,,"})
    void 자동차_입력_검증_실패(String carNames) {
        assertThat(RacingCar.isValidCarNames(carNames))
                .isEqualTo(false);
    }

    @DisplayName("실행 횟수가 양수인 경우 true를 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"5", "11", " 11 ", "7 "})
    void 자동차_실행_횟수_검증_성공(String count) {
        assertThat(RacingCar.isValidCount(count))
                .isEqualTo(true);
    }

    @DisplayName("실행 횟수가 음수이거나 정수가 아닌 경우 false를 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"5.1", "-999", " ARA ", "1 1"})
    void 자동차_실행_횟수_검증_실패(String count) {
        assertThat(RacingCar.isValidCount(count))
                .isEqualTo(false);
    }

    @DisplayName("랜덤함수가 0이상 9이하의 숫자를 리턴한다")
    @Test
    void 랜덤_함수_검증() {
        int result = RacingCar.generateRandom();
        assertThat(result).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

    @DisplayName("랜덤 값이 4 이상이면 자동차는 1만큼 전진한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_전진(int randomValue) {
        RacingCar racingCar = new RacingCar("");
        int previousCount = racingCar.moveCount;

        racingCar.move(randomValue);

        assertThat(racingCar.moveCount).isEqualTo(previousCount + 1);
    }

    @DisplayName("랜덤 값이 3 이하면 자동차는 정지한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차_정지(int randomValue) {
        RacingCar racingCar = new RacingCar("");
        int previousCount = racingCar.moveCount;

        racingCar.move(randomValue);

        assertThat(racingCar.moveCount).isEqualTo(previousCount);
    }

    @DisplayName("자동차들을 등록한다")
    @Test
    void 자동차_등록() {
        RacingCar[] cars = {new RacingCar("pobi"), new RacingCar("crong"), new RacingCar("honux")};

        RacingGame racingGame = new RacingGame(cars,5);

        for (RacingCar car : racingGame.cars) {
            assertThat(cars).contains(car);
        }
    }
}
