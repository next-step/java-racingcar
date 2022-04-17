package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Name 테스트")
class NameTest {

    @Test
    void _5글자_이하의_문자열을_입력받아_Wrapping_하는_겍체_생성() {
        String expect = "12345";

        Name name = new Name(expect);

        assertThat(name.getValue()).isEqualTo(expect);
    }

    @Test
    void 공백_문자열을_입력받으면_예외() {
        assertThatThrownBy(() -> new Name("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void _5글자_초과의_문자열을_입력받으면_예외() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
