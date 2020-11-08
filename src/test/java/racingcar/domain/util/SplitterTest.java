package racingcar.domain.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


class SplitterTest {
    @ParameterizedTest
    @CsvSource(value = {"test,true", "longName,false", "names,true"})
    @DisplayName(value = "5글자가 넘는 이름을 막기 위한 테스트")
    public void isValidateName_ShouldGenerateTheExpected(String name, boolean expected) {
        assertThat(isLong(name)).isEqualTo(expected);
    }

    @DisplayName("Name이 5글자 이하일때만 true를 리턴함")
    public boolean isLong(String name) {
        return name.length() <= 5;
    }

}