package com.nextstep.racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DriverNameParserTests {
    @DisplayName("쉼표로 구분된 문자열을 입력받아서 운전자명 리스트로 바꾸는지 확인")
    @Test
    void stringParseTest() {
        String testInput = "poppo,saul,ita";
        List<String> driverNames = DriverNameParser.toUserNameList(testInput);
        assertThat(driverNames).containsExactly("poppo", "saul", "ita");
    }
}
