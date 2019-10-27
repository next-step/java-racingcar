package step2;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("EqualCarDistanceGenerator should")
class EqualCarDistanceGeneratorTest {
    @Test
    @DisplayName("return same value always")
    void next() {
        final int generatedValue = 10;
        final CarDistanceGenerator generator = new EqualCarDistanceGenerator(generatedValue);

        IntStream.range(0, 1000)
                 .forEach(i -> {
                     final int next = generator.next();
                     assertThat(next).isEqualTo(generatedValue);
                 });
    }
}