package study.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    @DisplayName("이름 생성")
    void create() {
        //given
        String inputName = "juu";

        //when
        Name name = new Name(inputName);

        //then
        assertThat(name).isEqualTo(new Name("juu"));
    }

    @Test
    @DisplayName("이름에 빈칸이 들어갈 경우")
    void checkNameBlank() {
        //given
        String givenName = " ";

        //when //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Name name = new Name(givenName);
                });
    }

    @Test
    @DisplayName("이름이 다섯글자를 넘길 경우")
    void checkNameLength() {
        //given
        String givenName = "abcdef";

        //when //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Name name = new Name(givenName);
                });
    }

}