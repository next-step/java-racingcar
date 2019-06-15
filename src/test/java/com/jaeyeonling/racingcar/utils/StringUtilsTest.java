package com.jaeyeonling.racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @DisplayName("repeat 테스트")
    @ParameterizedTest
    @CsvSource({
            "-,0",
            "-,1",
            "-,5",
            "asdfsa,100",
            "3rrrrwf3,30",
            "!!!,23",
            "grt4,1",
            "-,123"
    })
    void repeat(final String replaceString,
                final int repeatCount) {
        // given
        StringBuilder verifyStringBuilder = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            verifyStringBuilder.append(replaceString);
        }

        // when
        final String repeatString = StringUtils.repeat(replaceString, repeatCount);

        // then
        assertThat(repeatString).isEqualTo(verifyStringBuilder.toString());
    }
}
