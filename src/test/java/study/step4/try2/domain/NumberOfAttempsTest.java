package study.step4.try2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfAttempsTest {
    @Test
    void 시도할_횟수가_숫자_또는_양수인지_확인() {
        String userInputNumberOfAttempts = "3";
        NumberOfAttemps numberOfAttemps = new NumberOfAttemps(userInputNumberOfAttempts);
        assertThat(numberOfAttemps.valid(userInputNumberOfAttempts)).isTrue();
    }
}
