package racing;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class RandomMoveGeneratorTest {

    private RandomMoveGenerator moveNumberGenerator;

    @Before
    public void setup() {
        moveNumberGenerator = new RandomMoveGenerator();
    }

    @Test
    public void 랜덤값_생성_성공() {
        int value = moveNumberGenerator.generate();

        Assertions.assertThat(value).isBetween(0, moveNumberGenerator.MAX_MOVE_SIZE);
    }

    @Test
    public void 랜덤값_최소_최대값_검증() {
        int[] values = new int[20];

        for (int i = 0; i < values.length; i++) {
            Assertions.assertThat(moveNumberGenerator.generate()).isBetween(0, moveNumberGenerator.MAX_MOVE_SIZE);
        }

    }
}