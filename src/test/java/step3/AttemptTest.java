package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AttemptTest {
    @ParameterizedTest
    @CsvSource({"1, true", "4, false"})
    void testIsEnd(int number, boolean expect) {
        Attempt attempt = new Attempt(number);
        attempt.make();
        boolean isEnd = attempt.isEnd();
        assertThat(isEnd).isEqualTo(expect);
    }

}