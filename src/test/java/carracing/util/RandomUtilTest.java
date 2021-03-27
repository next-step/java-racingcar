package carracing.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilTest {

    private final char DELIMITER = ':';

    private static final int CRITERIA_FOR_WIN = 4;

    @ParameterizedTest
    @CsvSource(value = {"4:true", "3:false", "7:true"}, delimiter = DELIMITER)
    public void testForward(int randomNum, boolean result) {
        boolean isWin = randomNum >= CRITERIA_FOR_WIN;

        assertThat(isWin).isEqualTo(result);

    }

}