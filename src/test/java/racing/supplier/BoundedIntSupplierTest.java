package racing.generator;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BoundedIntGeneratorTest {

    @Test
    public void test_랜덤값_생성() {
        int bound = 10;
        IntSupplier generator = new BoundedIntSupplier(bound);
        for (int i = 0; i < 100; i++) {
            assertThat(generator.nextInt()).isLessThan(bound);
        }
    }
}