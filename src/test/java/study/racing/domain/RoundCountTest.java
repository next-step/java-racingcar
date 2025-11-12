package study.racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundCountTest {

    @Test
    void 라운드_카운트_생성한다() {
        RoundCount roundCount = new RoundCount(3);
        assertEquals(3, roundCount.getValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 라운드_카운트가_0이하이면_예외가_발생한다(int input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new RoundCount(input);
        });
    }


    @Test
    void 같은_횟수이면_동등성을_가진다() {
        RoundCount roundCount1 = new RoundCount(3);
        RoundCount roundCount2 = new RoundCount(3);

        assertEquals(roundCount1, roundCount2);
    }
}
