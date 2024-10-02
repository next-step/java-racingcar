package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.CarInfo;
import racing.model.RoundResult;
import racing.model.collection.Cars;
import racing.model.collection.GameResult;
import racing.util.FixedNumberGenerator;
import racing.util.RandomNumberGenerator;

class RacingGameTest {

    @DisplayName("생성자를 통해 자동차 리스트와 라운드 수를 잘 생성하는지")
    @Test
    void setUpTest() {
        Cars cars = Cars.create(
                Arrays.asList("테스터1", "테스터2", "테스터3", "테스터4", "테스터5"),
                new RandomNumberGenerator()
        );

        RacingGame newGame = RacingGame.setUp(1, cars);
        assertThat(newGame.getRoundCount()).isEqualTo(1);
        assertThat(newGame.getCars()).isEqualTo(cars);
    }

    @DisplayName("게임이 시작되면 라운드 수만큼의 결과 객체를 잘 반환하는지")
    @Test
    void startTest() {
        Cars cars = Cars.create(
                Arrays.asList("테스터1", "테스터2", "테스터3", "테스터4", "테스터5"),
                new FixedNumberGenerator(5)
        );

        RacingGame newGame = RacingGame.setUp(1, cars);
        GameResult gameResult = newGame.start();

        List<RoundResult> results = gameResult.getRoundResults();
        assertThat(results).hasSize(1);

        List<Integer> expectedPositions = Arrays.asList(1, 1, 1, 1, 1);

        RoundResult result = results.get(0);

        assertThat(result.getCarInfos()
                .stream()
                .map(CarInfo::getPosition)
                .collect(Collectors.toList())
        ).isEqualTo(expectedPositions);
    }

    @DisplayName("게임이 끝난 후 우승자를 잘 반환하는지")
    @Test
    void getWinnersFromGameResultTest() {
        Cars cars = Cars.create(
                Arrays.asList("pobi", "honux", "linux"),
                new FixedNumberGenerator(5)
        );

        RacingGame racingGame = RacingGame.setUp(5, cars);
        GameResult gameResult = racingGame.start();

        List<String> winners = gameResult.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("honux", "pobi", "linux");
    }
}
