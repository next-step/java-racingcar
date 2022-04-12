package racing.module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarGameTest {
    @Test
    @DisplayName("대수가 맞게 생성되었는지 확인")
    void carGame() {
        CarGame carGame = new CarGame(3);
        assertThat(carGame.getCarList().size()).isEqualTo(3);
    }
}