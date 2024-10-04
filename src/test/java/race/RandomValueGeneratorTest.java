package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomValueGeneratorTest {
    @Test
    void create_난수생성기를_생성한다() {
        IRandomValueGenerator randomValueGenerator = RandomValueGenerator.create();
        assertThat(randomValueGenerator).isInstanceOf(RandomValueGenerator.class);
    }

    @Test
    void generateFromZeroTo_0부터_입력_받은_수보다_작은_수까지의_난수를_반환한다() {
        IRandomValueGenerator randomValueGenerator = RandomValueGenerator.create();
        int end = 10;

        int result = randomValueGenerator.generateFromZeroTo(end);

        assertThat(result).isGreaterThanOrEqualTo(0);
        assertThat(result).isLessThan(end);
    }
}