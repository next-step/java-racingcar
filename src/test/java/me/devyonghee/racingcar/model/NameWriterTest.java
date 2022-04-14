package me.devyonghee.racingcar.model;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("작명가")
class NameWriterTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> NameWriter.from("abc"));
        assertThatNoException().isThrownBy(() -> NameWriter.from("abc,123"));
    }

    @ParameterizedTest
    @DisplayName("반드시 문자가 존재해야 함")
    @NullAndEmptySource
    void instance_blank_thrownIllegalArgumentException(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> NameWriter.from(names));
    }

    @Test
    @DisplayName("이름들 추출")
    void names() {
        assertThat(NameWriter.from("abc,123").names())
                .extracting(Names::list, InstanceOfAssertFactories.list(Name.class))
                .containsExactly(Name.from("abc"), Name.from("123"));
    }

    @Test
    @DisplayName("구분자가 없는 경우 이름 동일하게 출력")
    void names_withoutDelimiter() {
        //given
        String name = "abc";
        //when, then
        assertThat(NameWriter.from(name).names())
                .extracting(Names::list, InstanceOfAssertFactories.list(Name.class))
                .containsExactly(Name.from(name));
    }
}
