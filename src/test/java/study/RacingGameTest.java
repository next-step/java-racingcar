package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    int count;
    int time;
    int[] carPositions;

    @BeforeEach
    void setUp() {
        count = 3;
        time = 5;
        carPositions = new int[count];
    }

    @Test
    public void move() {
        Random random = new Random();

        for (int i = 0; i < carPositions.length; i++) {

            //int ranCount = random.nextInt(10);
            int ranCount = 4;
            if (ranCount >= 4) {
                carPositions[i] = carPositions[i] + 1;
            }
        }

        assertThat(carPositions[0]).isEqualTo(1);
    }

}
