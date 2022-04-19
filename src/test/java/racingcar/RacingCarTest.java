package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private static final int MOVE = 4;
    private static final int STAY = 3;
    private RacingCar mockCar;
    private RacingCar highestScoreCar;

    @BeforeEach
    void setUp() {
        mockCar = new RacingCar("name");
        highestScoreCar = new RacingCar("highestScoreCar");
    }

    @Test
    void randomIsOverThan3Given_ShouldMove() {
        assertThat(mockCar.move(MOVE)).isEqualTo(1);
    }

    @Test
    void randomIsUnderThan4Given_ShouldStay() {
        assertThat(mockCar.move(3)).isEqualTo(0);
    }

    @Test
    void randomIsOverThan3TwiceGiven_ShouldMoveTwice() {
        mockCar.move(MOVE);
        mockCar.move(MOVE);
        assertThat(mockCar.getMovement()).isEqualTo(2);
    }

    @Test
    void movementIsEqualWithHighestScoreGiven_ShouldReturnName() {
        // given
        mockCar.move(MOVE);
        highestScoreCar.move(MOVE);

        // then
        assertThat(mockCar.compareWithHighestScoreCar(highestScoreCar)).isEqualTo("name");
    }

    @Test
    void movementIsLowerThanHighestScoreGiven_ShouldReturnEmpty() {
        mockCar.move(STAY);
        highestScoreCar.move(MOVE);

        assertThat(mockCar.compareWithHighestScoreCar(highestScoreCar)).isEqualTo("");
    }
}
