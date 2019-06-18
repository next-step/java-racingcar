package RacingGame;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    private final String INPUT_NAMES = "jojo,mike,brian,cell,chacha";
    private Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing(5,this.INPUT_NAMES);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void setTime(int input) {
        racing = new Racing(input, this.INPUT_NAMES);
        assertThat(racing.getTime()).isEqualTo(input);
    }

    @Test
    void makeCarList() {
        racing = new Racing(0, this.INPUT_NAMES);
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
    void splitStringNames() {
        List<String> carNames = racing.splitCarNames(this.INPUT_NAMES);
        assertThat(carNames).contains("jojo","mike","brian","cell","chacha");
    }

    @Test
    void constructorRacing() {
        racing = new Racing(0, this.INPUT_NAMES);
    }
}