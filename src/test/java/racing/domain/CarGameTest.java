package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarGameTest {
    @Test
    void start_성공() {
        String[] names = {"park", "kim"};
        CarGame carGame = new CarGame(5, () -> true, names);
        RoundRecords result = carGame.start();
        assertThat(result.size()).isEqualTo(5);
    }

}