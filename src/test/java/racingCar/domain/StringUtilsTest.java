package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringUtilsTest {

    @DisplayName("문자열 split 테스트")
    @Test
    void string_split_test() {
        String[] names = StringUtils.namesSpliter("pobi,crong,honux");
        assertThat(names.length).isEqualTo(3);
    }

    @DisplayName("문자열 길이가 5이하인지 테스트")
    @CsvSource(value = {"pobi,true", "sponge,false"})
    @ParameterizedTest()
    void string_length_test(String name, boolean expect) {
        assertThat(StringUtils.checkStringLength(name)).isEqualTo(expect);
    }
}
