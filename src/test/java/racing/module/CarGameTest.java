package racing.module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarGameTest {
    @Test
    @DisplayName("대수가 맞게 생성되었는지 확인")
    void carGame() {
        CarGame carGame = new CarGame(3);
        assertThat(carGame.getCarList().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    @DisplayName("생성된 자동차들이 모두 맞게 움직였는지 확인")
    void play(int input, int output) {
        CarGame carGame = new CarGame(3);
        carGame.play(new ManualNumberGenerator(), input);
        for (Car car : carGame.getCarList()) {
            assertThat(car.getPosition()).isEqualTo(output);

        }
    }
}