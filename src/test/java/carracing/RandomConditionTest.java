package carracing;

import carracing.util.RandomCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomConditionTest {

    @Test
    @DisplayName("Random 숫자 생성 테스트")
    void randomCondition() {
        Assertions.assertThat(RandomCondition.getCondition()).isLessThan(10);
    }
}
