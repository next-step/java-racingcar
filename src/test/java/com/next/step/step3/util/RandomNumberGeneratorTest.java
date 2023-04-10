package com.next.step.step3.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    private static final int MIN_NUM = 0;

    private static final int MAX_NUM = 9;

    @RepeatedTest(10)
    @DisplayName("랜덤 값을 생성할 때 범위내에 존재하는지 테스트")
    void generateRandomNum_범위내에_있는지_테스트() {
        int randomNum = RandomNumberGenerator.generateRandomNum();
        assertThat(randomNum).isGreaterThanOrEqualTo(MIN_NUM).isLessThanOrEqualTo(MAX_NUM);
    }
}
