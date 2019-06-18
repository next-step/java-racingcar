package RacingGame;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing(5,5);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void setTime(int input) {
        racing = new Racing(input, 0);
        assertThat(racing.getTime()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void makeCarList(int carCount) {
        racing = new Racing(0, carCount);
        assertThat(racing.getCars().size()).isEqualTo(carCount);
        assertThat(racing.getCars().get(0).getPosition()).isEqualTo(0);
    }

    @Test
    void setCars() {
        assertThat(racing.getCars().size()).isEqualTo(5);
    }

    @Test
    void raceCarMoveLoop() {
        racing.raceCarMoveLoop();
    }

    @Test
    void raceStart() {
        racing.raceStart();
    }
}