package racingcar.v2.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringUtilsTest {


    @Test
    void 입력문자열분리_테스트() {
        String input = "hog,asd,hize";
        String[] names = StringUtils.split(input);
        assertThat(names.length).isEqualTo(3);
    }

    @Test
    void 이름5자초과_테스트() {
        assertThat(StringUtils.isMoreThanFiveLetters("hong2")).isTrue();
        assertThat(StringUtils.isMoreThanFiveLetters("hong")).isFalse();
    }

    @Test
    void 문자열공백_테스트() {
        assertThat(StringUtils.isBlank(" ")).isTrue();
        assertThat(StringUtils.isBlank("hog")).isFalse();

    }
}