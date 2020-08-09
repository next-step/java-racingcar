package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    @DisplayName("자동차 대수와 시도횟수를 입력받아 게임을 초기화한다.")
    public void input_carCount_and_create_cars() {
        // given
        Game game = new Game(4, 3);

        // then
        assertThat(game.getCars().length).isEqualTo(4);
        assertThat(game.getTryCount()).isEqualTo(3);
    }

}
