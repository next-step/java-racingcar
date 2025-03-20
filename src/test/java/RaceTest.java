import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    @DisplayName("경기 시작시 자동차의 위치는 0이다")
    void carPositionsAtStartAreZero() {
        String[] carNames = {"car1", "car2", "car3", "car4", "car5"};
        Race race = new Race(new GameSettings(carNames, 3));
        for (CarStatus carStatus : race.getCarStatuses()) {
            assertThat(carStatus.getPosition()).isZero();
        }
    }

    @Test
    @DisplayName("한 라운드가 진행되면 자동차의 위치는 기존 위치이거나, 기존 위치 + 1이다")
    void carPositionsAfterOneRoundAreEitherSameOrIncremented() {
        String[] carNames = {"car1", "car2", "car3", "car4", "car5"};
        Race race = new Race(new GameSettings(carNames, 3));
        List<CarStatus> initialStatuses = race.getCarStatuses();

        race.runRound();
        List<CarStatus> finalStatuses = race.getCarStatuses();

        for (int i = 0; i < initialStatuses.size(); i++) {
            assertThat(finalStatuses.get(i).getPosition()).isIn(initialStatuses.get(i).getPosition(), initialStatuses.get(i).getPosition() + 1);
        }
    }

    @Test
    @DisplayName("전체 라운드를 넘어가면 에러가 발생한다")
    void exceedingTotalRoundsThrowsError() {
        String[] carNames = {"car1", "car2", "car3", "car4", "car5"};
        Race race = new Race(new GameSettings(carNames, 3));
        for (int i = 0; i < 3; i++) {
            race.runRound();
        }
        assertThatThrownBy(race::runRound).isInstanceOf(IllegalStateException.class).hasMessage("Race has already finished");
    }

    @Test
    @DisplayName("경주가 진행 중일 때 우승자를 조회하면 예외가 발생한다")
    void getWinnersBeforeRaceFinishThrowsError() {
        String[] carNames = {"car1", "car2"};
        Race race = new Race(new GameSettings(carNames, 3));
        race.runRound();  // 1라운드만 진행

        assertThatThrownBy(race::getWinners)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Race is still in progress");
    }

    @Test
    @DisplayName("단독 우승자가 있는 경우 해당 자동차만 반환한다")
    void getSingleWinner() {
        // given
        List<Car> cars = List.of(
            new Car("car1", 5),
            new Car("car2", 3),
            new Car("car3", 4)
        );
        Race race = new Race(cars, 1);

        // when
        List<CarStatus> winners = race.getWinners();

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("공동 우승자가 있는 경우 모든 우승자를 반환한다")
    void getMultipleWinners() {
        // given
        List<Car> cars = List.of(
            new Car("car1", 5),
            new Car("car2", 5),
            new Car("car3", 3)
        );
        Race race = new Race(cars, 1);

        // when
        List<CarStatus> winners = race.getWinners();

        // then
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting("name").containsExactlyInAnyOrder("car1", "car2");
    }
}
