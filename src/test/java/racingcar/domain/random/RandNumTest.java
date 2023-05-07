package racingcar.domain.random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.random.RandNum;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandNumTest {
    @Test
    void 전달받은_기준값_이상의_값일경우_true_를_리턴한다() {
        int randVal = 3;
        int smallValue = randVal - 1;
        RandNum randNum = new RandNum(randVal);

        Assertions.assertThat(randNum.isGreaterThan(smallValue)).isTrue();
    }
}
