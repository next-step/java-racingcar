package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @ParameterizedTest
    @CsvSource({"1, 2", "3, 4", "5, 6"})
    @DisplayName("자동차 게임에 참여하는 자동차와 시도가 정상적으로 객체 생성 되었는지 확인합니다")
    void ready(int carCount, int attemptCount) {
        RacingCars racingCars = new RacingCars(carCount);
        Attempt attempt = new Attempt(attemptCount);

        assertThat(new RacingCarGame(racingCars, attempt).equals(new RacingCarGame(racingCars, attempt))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux : 2"}, delimiter = ':')
    @DisplayName("자동차 게임에 참여하는 이름을 가진 자동차와 시도가 정상적으로 객체 생성 되었는지 확인합니다")
    void ready(String allRacingCarName, int attemptCount) {
        RacingCars racingCars = new RacingCars(allRacingCarName.split(","));
        Attempt attempt = new Attempt(attemptCount);
        assertThat(new RacingCarGame(racingCars, attempt).equals(new RacingCarGame(racingCars, attempt))).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3, 4", "3, 3, 4, 5"})
    @DisplayName("자동차 게임에 참여하는 자동차와 시도가 비정상적으로 객체 생성 되었는지 확인합니다")
    void notReady(int initialCarCount, int compareCarCount, int initialAttemptCount, int compareAttemptCount) {
        RacingCars initialRacingCars = new RacingCars(initialCarCount);
        Attempt initialAttempt = new Attempt(initialAttemptCount);

        RacingCars compareRacingCars = new RacingCars(compareCarCount);
        Attempt compareAttempt = new Attempt(compareAttemptCount);

        assertThat(new RacingCarGame(initialRacingCars, initialAttempt).equals(new RacingCarGame(compareRacingCars, compareAttempt))).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux : pobi,crong,choco : 2 : 2", "pobi,crong,honux : pobi,crong,honux : 2 : 3"}, delimiter = ':')
    @DisplayName("자동차 게임에 참여하는 이름을 가진 자동차와 시도가 비정상적으로 객체 생성 되었는지 확인합니다")
    void notReady(String initialCarNames, String compareCarCarNames, int initialAttemptCount, int compareAttemptCount) {
        RacingCars initialRacingCars = new RacingCars(initialCarNames.split(","));
        Attempt initialAttempt = new Attempt(initialAttemptCount);

        RacingCars compareRacingCars = new RacingCars(compareCarCarNames.split(","));
        Attempt compareAttempt = new Attempt(compareAttemptCount);

        assertThat(new RacingCarGame(initialRacingCars, initialAttempt).equals(new RacingCarGame(compareRacingCars, compareAttempt))).isFalse();
    }

    // 비정상적으로 생성시에 테스트도 같이 진행되어야 함
    // winner 테스트시 어떤 참여자가 우승자인지 테스트가 가능하게 하려면 random 숫자 부터 내가 주입할 수 있어야 하나?

}