package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarGameTest {
    @Test
    void start_성공() {
        CarGame carGame = new CarGame(3, 5, () ->true);
        List<RoundRecord> result = carGame.start();
        assertThat(result).hasSize(5);
    }

}