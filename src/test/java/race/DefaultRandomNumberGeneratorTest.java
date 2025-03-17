package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultRandomNumberGeneratorTest {
    @Test
    void getRandomNumber() {
        DefaultRandomNumberGenerator defaultRandomNumberGenerator = new DefaultRandomNumberGenerator();
        assertThat(defaultRandomNumberGenerator.generate()).isBetween(0, 9);
    }
}
