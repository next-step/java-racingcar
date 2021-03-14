package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class RacingTest {
    String[] namesOfCars = {"가나다라마", "바사아", "자차", "카", "타파하"};

    @DisplayName("주어진 조건으로 레이싱게임을 생성한다.")
    @Test
    void withCondition() {
        int numberOfTurns = 5;
        Racing racing = Racing.withCondition(namesOfCars, numberOfTurns);

        assertThat(racing.getCars().size()).isEqualTo(namesOfCars.length);
        assertThat(racing.getNumberOfTurns()).isEqualTo(numberOfTurns);
    }

    @DisplayName("주어진 횟수만큼 레이싱을 진행할 수 있다.")
    @Test
    void race() {
        int numberOfTurns = 1;
        Racing racing = Racing.withCondition(namesOfCars, numberOfTurns);

        while (numberOfTurns > 0) {
            assertThat(racing.hasRaceEnd()).isFalse();
            racing.race();
            numberOfTurns--;
        }
        assertThat(racing.hasRaceEnd()).isTrue();
    }

    @DisplayName("레이싱의 우승자를 구한다")
    @Test
    void getWinners() {
        // given
        Racing racing = Racing.withCondition(namesOfCars, 0);
        List<Car> cars = racing.getCars();
        Car winner1 = cars.get(0);
        Car winner2 = cars.get(1);
        winner1.moveOrStay(MovingForwardCondition.THRESHOLD);
        winner2.moveOrStay(MovingForwardCondition.THRESHOLD);

        // when
        List<Car> winners = racing.getWinners();

        // then
        assertThat(winners).contains(winner1, winner2);
    }

    @DisplayName("레이싱이 종료되지 않았는데 getWinners 를 호출하면 IllegalStateException 을 던진다.")
    @Test
    void getWinners_onFail() {
        // given
        Racing racing = Racing.withCondition(namesOfCars, 3);

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(racing::getWinners);
    }

}
