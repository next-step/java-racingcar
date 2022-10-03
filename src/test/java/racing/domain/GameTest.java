package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.rule.move.RandomMove;

import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @Test
    @DisplayName("생성자 주입 - 게임 설정 값 검증")
    void 생성자주입_설정값_검증() {
        GameSet gameSet = new GameSet.GameSetBuilder(
                new RandomMove(), Arrays.asList("a","b","c"), 3).build();
        Game game = new Game(gameSet);

        assertThat(game.getGameSet()).isEqualTo(gameSet);
        assertThat(gameSet.getCarNames().size()).isEqualTo(3);
        assertThat(gameSet.getNumberOfMove()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성자 주입 - 게임 설정 값 예외 발생")
    void 생성자주입_설정값_예외발생_검증() {
        assertThatThrownBy(() -> new Game(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주차목록_불변성_검증() {
        Game game = new Game(new GameSet.GameSetBuilder(new RandomMove(), Arrays.asList("car1", "car2"), 3).build());
        List<Car> cars = game.getCars();
        assertThatThrownBy(() -> cars.add(new Car("car3")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
