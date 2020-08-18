package racingcarbasic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @ParameterizedTest
    @CsvSource(value = {"0, 1, 2, 3, 4, 5, 6, 7, 8, 9"}, delimiter = ',')
    void 전진(int num) {
        MoveStrategy functionalTest = () -> num>=0;
        assertThat(functionalTest.move()).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 1, 2, 3, 4, 5, 6, 7, 8, 9"}, delimiter = ',')
    void 멈춤(int num) {
        MoveStrategy functionalTest = () -> num>=10;
        assertThat(functionalTest.move()).isEqualTo(false);
    }
}
