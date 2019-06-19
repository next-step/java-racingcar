package homework.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarGameEngineTest {
    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @Test
    void racingCarGameEngineConstructor() {
        System.out.println("racingCarGameEngineConstructor");
        RacingCarGameEngine carGameEngine = new RacingCarGameEngine(5, new int[3]);
        assertThat(carGameEngine.getNumbersOfRacing()).isEqualTo(5);
        assertThat(carGameEngine.getCarPositions().length).isEqualTo(3);
    }
}
