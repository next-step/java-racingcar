package racingcar.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class MoveTest {
    @ParameterizedTest(name = "MoveRandom 체크 {0}:{1}")
    @CsvSource(value= {"3:false", "5:true"}, delimiter = ':')
    void goOrStop(int input, boolean result)
    {
        Move control = new MoveRandom();

        assertThat(control.goOrStop(input)).isEqualTo(result);
    }

}
