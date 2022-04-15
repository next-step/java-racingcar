package me.devyonghee.racingcar.model;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 이름 작명가")
class CarNameWriterTest {

    @ParameterizedTest
    @DisplayName("객체화")
    @ValueSource(strings = {"abc", "abc,123"})
    void instance(String names) {
        assertThatNoException().isThrownBy(() -> NameWriter.from(names));
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
                .extracting(CarNames::list, InstanceOfAssertFactories.list(CarName.class))
                .containsExactly(CarName.from("abc"), CarName.from("123"));
    }

    @Test
    @DisplayName("구분자가 없는 경우 이름 동일하게 출력")
    void names_withoutDelimiter() {
        //given
        String name = "abc";
        //when, then
        assertThat(NameWriter.from(name).names())
                .extracting(CarNames::list, InstanceOfAssertFactories.list(CarName.class))
                .containsExactly(CarName.from(name));
    }
}
