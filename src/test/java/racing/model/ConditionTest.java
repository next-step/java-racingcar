package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConditionTest {

    @DisplayName("조건 값 생성")
    @RepeatedTest(100)
    void 조건값() {
        assertThat(Condition.generate()).isLessThan(11);
    }
}