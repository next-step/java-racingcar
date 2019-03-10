package racing.random;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BoundedRandomGeneratorTest {

    @Test
    public void test_nextInt() {
        int bound = 10;
        RandomGenerator generator = new BoundedRandomGenerator(bound);
        for (int i = 0; i < 100; i++) {
            assertThat(generator.nextInt()).isLessThan(bound);
        }
    }
}