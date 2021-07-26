package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    List<Car> carList = Arrays.asList(
            new Car("pobi"),
            new Car("crong"),
            new Car("honux"));

    @Test
    @DisplayName("자동차 이름 List와 반복횟수를 매개변수로 게임 생성")
    void create() {
        Game game = new Game(carList, 5);
        assertThat(game.getCars()).hasSize(3);
        assertThat(game.getCars()).containsExactly(
                new Car("pobi"),
                new Car("crong"),
                new Car("honux"));
        assertThat(game.getRepeatCount()).isEqualTo(5);
    }

    @ParameterizedTest(name = "{displayName} [{index}]")
    @CsvSource(value = {"0", "-1", "-5"}, delimiter = ':')
    @DisplayName("반복횟수는 0 혹은 음수가 될 수 없다.")
    void valid(int repeatSize) {
        assertThatThrownBy(() -> new Game(carList, repeatSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 실행")
    void run() {
        Game game1 = new Game(carList, 5);
        assertThat(game1.runOnce(Arrays.asList(4, 4, 4))).isTrue();
        assertThat(game1.getCars()).containsExactly(
                new Car("pobi", 1),
                new Car("crong", 1),
                new Car("honux", 1));

        Game game2 = new Game(Arrays.asList(new Car("pobi"),
                new Car("crong"),
                new Car("honux"),
                new Car("dodo")), 5);
        assertThat(game2.runOnce(Arrays.asList(4, 3, 6, 3))).isTrue();
        assertThat(game2.getCars()).containsExactly(
                new Car("pobi", 1),
                new Car("crong", 0),
                new Car("honux", 1),
                new Car("dodo", 0));
    }

    @Test
    @DisplayName("우승자 찾기")
    void findWinner() {
        Game game = new Game(Arrays.asList(
                new Car("pobi", 5),
                new Car("crong", 4),
                new Car("honux", 5)), 5);
        List<Car> winners = game.findWinners();
        assertThat(winners).containsExactly(new Car("pobi", 5), new Car("honux", 5));
    }
}
