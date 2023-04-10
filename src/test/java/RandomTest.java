import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    @Test
    void random_0이상_3이하() {
        for (int i = 0; i < 20; i++) {
            int number = (int) (Math.random() * 4);
            assertThat(number).isIn(0, 1, 2, 3);
        }
    }

    @Test
    void random_4이상_9이하() {
        for (int i = 0; i < 20; i++) {
            int number = (int) (Math.random() * 6 + 4);
            assertThat(number).isIn(4, 5, 6, 7, 8, 9);
        }
    }
}
