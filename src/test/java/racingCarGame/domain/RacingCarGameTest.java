package racingCarGame.domain;

import org.junit.jupiter.api.Test;
import racingCarGame.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarGameTest {
    @ParameterizedTest
    @CsvSource(
            value = {
                    "NotM, NotM, M, 1",
                    "NotM, M, M, 2",
                    "M, M, M, 3"
            },
            delimiter = ',')
    @DisplayName("findWinner()는 가장 높은 점수를 가진 우승자 여러명을 찾아준다.")
    void getMultipleWinners(
            String strategy1,
            String strategy2,
            String strategy3,
            String winnerCount
    ) {
        InputView input = new InputView("pobi,yong,kei", 3);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(input.getOwners().get(0), getStrategy(strategy1)));
        cars.add(new Car(input.getOwners().get(1), getStrategy(strategy2)));
        cars.add(new Car(input.getOwners().get(2), getStrategy(strategy3)));
        RacingCarGame racingCarGame = new RacingCarGame(cars);
        racingCarGame.race();

        assertThat(racingCarGame.findWinner().size()).isEqualTo(Integer.parseInt(winnerCount));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "NotM, M, NotM, yong",
            },
            delimiter = ',')
    @DisplayName("findWinner()는 가장 높은 점수를 가진 우승자를 찾아준다.")
    void getOnlyWinner(
            String strategy1,
            String strategy2,
            String strategy3,
            String winner
    ) {
        InputView input = new InputView("pobi,yong,kei", 3);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(input.getOwners().get(0), getStrategy(strategy1)));
        cars.add(new Car(input.getOwners().get(1), getStrategy(strategy2)));
        cars.add(new Car(input.getOwners().get(2), getStrategy(strategy3)));
        RacingCarGame racingCarGame = new RacingCarGame(cars);
        racingCarGame.race();

        assertThat(racingCarGame.findWinner().size()).isEqualTo(1);
        assertThat(racingCarGame.findWinner().get(0)).isEqualTo(winner);
    }

    @Test
    public void raceTest() {
        InputView input = new InputView("pobi,yong,kei", 3);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(input.getOwners().get(0), new AlwaysMoveStrategy()));
        cars.add(new Car(input.getOwners().get(1), new AlwaysMoveStrategy()));
        cars.add(new Car(input.getOwners().get(2), new AlwaysMoveStrategy()));
        RacingCarGame racingCarGame = new RacingCarGame(cars);
        racingCarGame.race();

        racingCarGame.getCars().forEach(car -> assertThat(car.getDistance()).isEqualTo(1));
    }

    private MoveStrategy getStrategy(String strategy) {
        if (strategy.equals("NotM")) {
            return new NotMoveStrategy();
        }
        return new AlwaysMoveStrategy();
    }
}
