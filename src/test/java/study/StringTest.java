package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("학습 테스트 실습 1단계 - Junit, AssertJ 사용법 숙지")
public class StringTest {

    @ParameterizedTest
    @ValueSource(strings = "1,2")
    @DisplayName("[요구사항 1] '1,2' 문자열을 ','으로 split 할 때 '1', '2'로 잘 분리되는지 확인")
    void validateContainsElementsInReturnStringArrayWhenUseSplitMethod(final String givenInput) {
        final String separator = ",";
        final String one = "1";
        final String two = "2";

        final String[] splitStrArr = givenInput.split(separator);

        assertThat(splitStrArr).contains(one, two);
        assertThat(splitStrArr).containsExactly(one, two);
    }
}
