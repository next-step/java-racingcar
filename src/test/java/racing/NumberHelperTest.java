package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author han
 */
class NumberHelperTest {

    NumberHelper numberHelper;

    @Test
    void getRandomValue() {
        assertThat(numberHelper.getRandomValue()).isLessThan(10);
    }
}