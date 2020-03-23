package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    int count;
    int time;
    int[] carPositions;
    String[] carNameArr;

    private final int BASE_POINT = 4;
    private final int RANDOM_BOUND = 10;
    private final int DISTANCE = 1;

    @BeforeEach
    void setUp() {
        count = 3;
        time = 5;
        carPositions = new int[count];

        carPositions[0] = 2;
        carPositions[1] = 4;
        carPositions[2] = 1;
    }

    @Test
    public void move() {
        Random random = new Random();

        for (int i = 0; i < carPositions.length; i++) {

            //int ranCount = random.nextInt(10);
            int ranCount = 4;
            carPositions[i] = (ranCount >= BASE_POINT) ? carPositions[i] + DISTANCE : carPositions[i];
        }

        assertThat(carPositions[0]).isEqualTo(1);
    }

    @Test
    public void showWinner() {
        int max = 0;
        for (int i = 0; i < carPositions.length; i++) {
            max = Math.max(carPositions[i], max);
        }

        assertThat(max).isEqualTo(4);
    }

}
