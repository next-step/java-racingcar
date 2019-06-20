package racingGame;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.domain.Racing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingTest {

    private Racing racing;
    private List<String> inputNames;

    @BeforeEach
    void setUp() {
        inputNames = Util.stringSplitToList("jojo,mike,brian,cell,chacha", ",");
        racing = new Racing(5, this.inputNames);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void setTime(int input) {
        racing = new Racing(input, this.inputNames);
        assertThat(racing.getTime()).isEqualTo(input);
    }

    @Test
    void makeCarList() {
        racing = new Racing(0, this.inputNames);
        assertThat(racing.getCars().size()).isEqualTo(5);
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

    @Test
    void constructorRacing() {
        racing = new Racing(0, this.inputNames);
    }

    @Test
    void maxPosition() {
        racing.raceStart();
        int maxPosition = racing.maxPosition();
        assertThat(maxPosition).isNotZero();
    }

    @Test
    void winners() {
        List<String> winners = racing.getWinnerNames();
        assertThat(winners.size()).isNotZero();
    }

    @Test
    void constructRacingValidTime() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> racing.validConstructTime(0));
    }

    @Test
    void constructRacingValidCars() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> racing.constructRacingValidNames(Arrays.asList("")));
    }
}
