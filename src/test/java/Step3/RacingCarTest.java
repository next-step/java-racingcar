package Step3;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    RacingCar racingCar = new RacingCar("test" , 0);

    // params: random_value, move_distance
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 1",
            "5, 1",
            "6, 1",
            "7, 1",
            "8, 1",
            "9, 1"
    })
    void move_if_rand_is_equal_or_greater_than_four(int rand, int distance) {
        int prev_pos = racingCar.getPosition();

        racingCar.move(rand);

        assertThat(racingCar.getPosition()).isEqualTo(prev_pos + distance);
    }
}
