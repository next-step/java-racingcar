package racing.resolver;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleAccelerateResolverTest {

    @Test
    void testSimpleResolver() {
        SimpleAccelerateResolver trueAccelerateResolver = new SimpleAccelerateResolver(true);
        assertThat(trueAccelerateResolver.resolve()).isTrue();

        SimpleAccelerateResolver falseAccelerateResolver = new SimpleAccelerateResolver(false);
        assertThat(falseAccelerateResolver.resolve()).isFalse();
    }
}
