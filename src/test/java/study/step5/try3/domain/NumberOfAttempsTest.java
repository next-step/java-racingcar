package study.step5.try3.domain;

import org.junit.jupiter.api.Test;
import study.step5.try3.domain.NumberOfAttempts;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberOfAttempsTest {
    @Test
    void 시도할_횟수가_숫자_또는_양수인지_확인() {
        assertThatThrownBy(()-> NumberOfAttempts.of("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
