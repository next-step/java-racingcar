package step4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private RacingGame racingGame;
    private int moveCount = 5;
    private List<Car> cars = Stream.of(new Car("pobi", "-----"), new Car("crong", "---"),
                                       new Car("honux", "-----"))
                                   .collect(
                                           Collectors.toList());

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(5, cars);
    }

    @DisplayName("자동차 경주 중 가장 많이 전진한 값을 확인한다.")
    @Test
    void maxRacingResult() {
        String maxResult = racingGame.maxRacingResult();
        assertThat(maxResult).isEqualTo("-----");
    }

    @DisplayName("자동자 경주 우승자 수를 확인한다.")
    @Test
    void getWinnerCount() {
        List<Car> cars = racingGame.winUsers(racingGame.maxRacingResult());
        assertThat(cars).hasSize(2);
    }

    @DisplayName("자동차 경주 우승자의 이름 목록을 확인한다.")
    @Test
    void getWinnerNameList() {
        List<Car> cars = racingGame.winUsers(racingGame.maxRacingResult());
        List<String> winnerNames = racingGame.getWinnerNames(cars);
        assertThat(winnerNames).containsExactly("pobi", "honux");
    }

    @DisplayName("자동차 경주 우승자의 가공한 이름을 확인한다.")
    @Test
    void getWinnerNames() {
        racingGame.setWinnerNames();
        String winnerNames = racingGame.getWinnerNames();
        assertThat(winnerNames).isEqualTo("pobi,honux");
    }

    @DisplayName("자동차 움직인 과정의 수를 확인한다.")
    @Test
    void moveCarPositions() {
        racingGame.racingByRepeatCount();
        assertThat(racingGame.getMoveCarPositions()).hasSize(moveCount);
    }

}
