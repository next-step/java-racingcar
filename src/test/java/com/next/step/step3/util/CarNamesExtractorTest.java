package com.next.step.step3.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesExtractorTest {

    @ParameterizedTest(name = "입력이 주어질 때 쉼표기준으로 자동차 이름들을 생성해주는지 확인하는 테스트")
    @MethodSource("provideCarNames")
    void extractCarNames_쉼표_기준으로_자동차이름_생성하는_테스트(String carNames, List<String> expected) {
        List<String> result = CarNamesExtractor.extractCarNames(carNames);
        assertThat(result).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of("a,b,c", List.of("a", "b", "c")),
                Arguments.of("pobi,crong,honux", List.of("pobi", "crong", "honux"))
        );
    }
}
