package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class RacingGameTest {
    String[] namesOfCars = {"가나다라마", "바사아", "자차", "카", "타파하"};

    @DisplayName("주어진 조건으로 레이싱게임을 생성한다.")
    @Test
    void withCondition() {
        int numberOfTurns = 5;
        RacingGame racingGame = RacingGame.withCondition(namesOfCars, numberOfTurns);

        assertThat(racingGame.getCars()).hasSize(namesOfCars.length);
        assertThat(racingGame.getNumberOfTurns()).isEqualTo(numberOfTurns);
    }

    @DisplayName("주어진 횟수가 남은 상태이면 레이싱을 진행하고 진행횟수를 감소시킨다 ")
    @Test
    void race_whenNumberOfTurnsRemains() {
        // given
        int numberOfTurns = 2;
        RacingGame racingGame = RacingGame.withCondition(namesOfCars, numberOfTurns);

        // when
        racingGame.race();

        // then
        assertThat(racingGame.getNumberOfTurns()).isEqualTo(numberOfTurns - 1);
    }

    @DisplayName("주어진 횟수만큼 레이싱을 하지않은 상태이면 레이싱을 진행하고 진행횟수를 감소시킨다 ")
    @Test
    void race_whenNumberOfTurnsExhausted() {
        // given
        int numberOfTurns = 0;
        RacingGame racingGame = RacingGame.withCondition(namesOfCars, numberOfTurns);

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(racingGame::race);
    }

    @DisplayName("주어진 횟수만큼 레이싱을 하지 않으면 false 를 리턴한다")
    @Test
    void hasRaceEnd_whenReturnFalse() {
        int numberOfTurns = 1;
        RacingGame racingGame = RacingGame.withCondition(namesOfCars, numberOfTurns);
        assertThat(racingGame.hasRaceEnd()).isFalse();
    }

    @DisplayName("주어진 횟수만큼 레이싱을 하면 ture 를 리턴한다")
    @Test
    void hasRaceEnd_whenReturnTrue() {
        int numberOfTurns = 1;
        RacingGame racingGame = RacingGame.withCondition(namesOfCars, numberOfTurns);
        racingGame.race();
        assertThat(racingGame.hasRaceEnd()).isTrue();
    }

    @DisplayName("레이싱의 우승자를 구한다")
    @Test
    void getWinners() {
        // given
        RacingGame racingGame = RacingGame.withCondition(namesOfCars, 0);
        List<Car> cars = racingGame.getCars();
        Car winner1 = cars.get(0);
        Car winner2 = cars.get(1);
        winner1.moveOrStay(Car.THRESHOLD);
        winner2.moveOrStay(Car.THRESHOLD);

        // when
        List<Car> winners = racingGame.getWinners();

        // then
        assertThat(winners).contains(winner1, winner2);
    }

    @DisplayName("레이싱이 종료되지 않았는데 getWinners 를 호출하면 IllegalStateException 을 던진다.")
    @Test
    void getWinners_onFail() {
        // given
        RacingGame racingGame = RacingGame.withCondition(namesOfCars, 3);

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(racingGame::getWinners);
    }

}
