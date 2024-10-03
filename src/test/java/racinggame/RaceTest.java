package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.racingcar.MoveStrategy;
import racinggame.racingcar.Race;
import racinggame.racingcar.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

class RaceTest {

    @ParameterizedTest
    @CsvSource({
            "'a,b,c,d,e', 5",
            "'pobi,crong,honux', 3",
    })
    @DisplayName("주어진 자동차 수로 경주를 생성하고 지정된 라운드 수만큼 진행한다")
    void createAndProceedRace(String nameInput, int numberOfRounds) {
        List<String> carNames = List.of(nameInput.split(","));
        MoveStrategy moveStrategy = new RandomMoveStrategy(); // 모든 자동차가 매 라운드마다 전진하도록 설정
        Race race = Race.create(moveStrategy, carNames);

        for (int i = 0; i < numberOfRounds; i++) {
            race.proceedRound();
        }

        Map<String, Integer> results = race.collectResults();

        assertThat(results).hasSize(carNames.size());
        carNames.forEach(carName -> assertThat(results.get(carName)).isBetween(0, numberOfRounds));
    }

    @ParameterizedTest
    @CsvSource({
            "'a,b,c,d,e', 5",
            "'pobi,crong,honux', 3",
    })
    @DisplayName("주어진 자동차 수로 경주를 생성하고 지정된 라운드 수만큼 진행한 후 우승자를 결정한다")
    void determineWinners(String nameInput, int numberOfRounds) {
        List<String> carNames = List.of(nameInput.split(","));
        MoveStrategy moveStrategy = () -> true; // 모든 자동차가 매 라운드마다 전진하도록 설정
        Race race = Race.create(moveStrategy, carNames);

        for (int i = 0; i < numberOfRounds; i++) {
            race.proceedRound();
        }

        List<String> winners = race.determineWinners();

        assertThat(winners).hasSize(carNames.size());
        assertThat(winners).containsAll(carNames);
    }
}
