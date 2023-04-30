package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 이름 객체가 생성되는지 확인")
    @Test
    void create_name() {
        Name name = new Name("test");
        assertThat(name).isEqualTo(new Name("test"));
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 자동차 이름에 null 또는 공백을 입력한 경우 IllegalArgumentException 예외가 발생하는지 확인")
    @ParameterizedTest(name = "testValue : {0}")
    @NullAndEmptySource
    void pass_null_or_blank_name_value_illegal_argument_exception(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 null 또는 공백일 수 없습니다.");
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 자동차 이름이 5자를 초과하는 경우 IllegalArgumentException 예외가 발생하는지 확인")
    @Test
    void pass_greater_than_5_letters_name_value_illegal_argument_exception() {
        assertThatThrownBy(() -> new Name("다섯글자초과"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 5글자를 초과할 수 없습니다.");
    }

}
