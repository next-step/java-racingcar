package CarRacing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    private static final CarRacing carRacing = new CarRacing();

    @ParameterizedTest
    @CsvSource(value = {"3:false", "4:true", "5:true"}, delimiter = ':')
    void 자동차_이동_가능여부_확인(int moveNum, boolean shouldMoveResult) {
        assertThat(carRacing.shouldMove(moveNum)).isEqualTo(shouldMoveResult);
    }
}
