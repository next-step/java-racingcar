package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    @DisplayName("자동차 대수를 입력받아 자동차를 생성한다.")
    public void input_car_count_and_create_cars() {
        Game game = new Game();
        game.getCarCount(4);

        assertThat(game.getCars().length).isEqualTo(4);

    }

}
