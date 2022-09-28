package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.rule.RandomRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @Test
    @DisplayName("생성자 주입 - 게임 설정 값 검증")
    void createConstructorWithSettings() {
        GameSet gameSet = new GameSet(new RandomRule());
        Game game = new Game(gameSet);
        gameSet.setNumberOfCars(3);

        assertThat(game.getGameSet()).isEqualTo(gameSet);
        assertThat(game.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성자 주입 - 게임 설정 값 예외 발생")
    void createConstructorWithSettingException() {
        assertThatThrownBy(() -> new Game(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
