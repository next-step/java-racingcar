package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import study.step3.util.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("유틸테스트")
public class UtilTest {

    @DisplayName("0 ~ 9 사이의 random 값을 생성해야 한다")
    @RepeatedTest(100)
    void numberGenerator() {
        int val = NumberGenerator.randomVal(10);

        assertThat(val).isNotNegative().isLessThan(10);
    }

}
