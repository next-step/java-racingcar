package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    public void nameCheckTest() {
        assertThatThrownBy(() -> {
            String given = "테스트용자동차이름";
            RacingGame racingGame = new RacingGame();
            racingGame.preparingGame(given, 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("시도 횟수는 양수여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void nameCheckTest(int count) {
        assertThatThrownBy(() -> {
            String given = "자동차이름";
            RacingGame racingGame = new RacingGame();
            racingGame.preparingGame(given, count);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("시도할 횟수는 양수여야 합니다.");
    }

    @DisplayName("경주 진행마다 각자 이름을 가진 결과를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"test", "pobi,crong,honux"})
    public void raceTest(String name) {
        // given
        RacingGame racingGame = new RacingGame();
        racingGame.preparingGame(name, 1);
        List<String> names = Arrays.asList(name.split(","));

        // when
        List<String> result = racingGame.race();

        // then
        assertThat(result).hasSize(names.size());
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i)).contains(names.get(i) + " : -");
        }
    }

    @Test
    @DisplayName("가장 많이 움직인 사람이 우승한다. : 우승자가 유일한 경우")
    public void getWinnerTestWithSingleWinner() {
        RacingGame racingGame = new RacingGame();
        List<Car> carList = this.getCarList();

        carList.get(0).goOrStop(true);

        List<String> winnerList = racingGame.getWinner(carList);
        assertThat(winnerList).hasSize(1);
        assertThat(winnerList).containsExactlyElementsOf(List.of("racer1"));
    }

    @DisplayName("가장 많이 움직인 사람이 우승한다. : 우승자가 2명인 경우")
    @Test
    public void getWinnerTestWithManyWinners() {
        RacingGame racingGame = new RacingGame();
        List<Car> carList = this.getCarList();

        carList.get(1).goOrStop(true);
        carList.get(2).goOrStop(true);

        List<String> winnerList = racingGame.getWinner(carList);
        assertThat(winnerList).hasSize(2);
        assertThat(winnerList).containsExactlyElementsOf(List.of("racer2", "racer3"));
    }

    private List<Car> getCarList() {
        List<Car> carList = new ArrayList<>();

        Car racer1 = new Car("racer1");
        Car racer2 = new Car("racer2");
        Car racer3 = new Car("racer3");

        carList.add(racer1);
        carList.add(racer2);
        carList.add(racer3);

        return carList;
    }

}