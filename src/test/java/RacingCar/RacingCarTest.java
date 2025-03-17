package RacingCar;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    private RacingCar racingCar;
    private static final int MOVE_CONDITION = 4;

    @BeforeEach
    void setUp(){
        racingCar = new RacingCar(MOVE_CONDITION);
    }

    @Test
    public void move(){
        int beforePosition = racingCar.position();
        racingCar.move();
        assertThat(racingCar.position() == beforePosition+1);
    }

    @Test
    public void generateRandom(){
        final int MAX_LEN = 10000;
        for (int i=0; i<MAX_LEN; i++){
            assertThat(racingCar.generateRandom(0, 9)).isBetween(0, 9);
        }
    }

    @Test
    public void checkMoveCondition(){
        final int THRESHOLD_VALUE = 4;
        assertThat(racingCar.checkMoveCondition(THRESHOLD_VALUE-1)).isEqualTo(false);
        assertThat(racingCar.checkMoveCondition(THRESHOLD_VALUE)).isEqualTo(true);
    }
}
