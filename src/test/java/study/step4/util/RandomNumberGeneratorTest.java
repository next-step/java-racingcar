package study.step4.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @DisplayName("랜덤생성기는 9를 초과하지 않는다")
    @RepeatedTest(100)
    void impl() {
        int result = RandomNumberGenerator.impl();
        assertThat(result).isLessThan(10);
    }
}