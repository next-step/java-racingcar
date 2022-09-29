package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {

    @ParameterizedTest
    @CsvSource(value = {"3,3", "3,5", "11,51"})
    @DisplayName("게임 초기 상태의 반복 값이 생성 시 전달받은 값과 동일해야 한다")
    void initGame(int count, int repeat) {
        Game game = new Game(count, repeat);

        assertThat(game).hasFieldOrPropertyWithValue("repeat", repeat);

    }

    @Test
    @DisplayName("실제 게임을 실행해 테스트한다")
    void test() {
        Game game = new Game(3, 5);
        game.start();
    }
}
