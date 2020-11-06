package racing.resolver;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomAccelerateResolverTest {
    @Test
    void testRandomResolver() {
        RandomAccelerateResolver randomAccelerateResolver = new RandomAccelerateResolver(10, 11);
        assertThat(randomAccelerateResolver.resolve()).isFalse();

        randomAccelerateResolver = new RandomAccelerateResolver(10, 0);
        assertThat(randomAccelerateResolver.resolve()).isTrue();
    }
}
