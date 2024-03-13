package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarGameTest {
    @Test
    void start_성공() {
        //String[] names = new String[1];
        String[] names = {"park", "kim"};
        CarGame carGame = new CarGame(5, () -> true, names);
        List<RoundRecord> result = carGame.start();
        assertThat(result).hasSize(5);
    }

}