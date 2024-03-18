package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarGameTest {
    @Test
    @DisplayName("성공: 게임 횟수 검증")
    void start_성공() {
        String[] names = {"park", "kim"};
        CarGame carGame = new CarGame(5, () -> true, names);
        RoundRecords result = carGame.start();
        assertThat(result.size()).isEqualTo(5);
    }
}