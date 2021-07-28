package racing_winner.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    private RacingCar racingCar;
    private static final int BASE_NUMBER = 0;
    private static final String BASE_WINNER = "";

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("pobi");
    }

    @Test
    void compareDistance() {
        racingCar.move();
        int distance = racingCar.compareDistance(BASE_NUMBER);
        assertThat(distance).isEqualTo(1);
    }

    @Test
    void findMovedMaxDistance() {
        String winner = racingCar.findMovedMaxDistance(BASE_NUMBER, BASE_WINNER);
        assertThat(winner).isEqualTo("pobi");
    }


}