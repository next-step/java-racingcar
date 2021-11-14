package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분")
    public void 입력받은_String_쉼표로_구분() {
        String[] result = "aaa,bbb,ccc".split(",");;
        assertThat(result).containsExactly("aaa", "bbb", "ccc");
    }

    @ParameterizedTest
    @CsvSource(value = {"aaa,true", "bbbbb,true", "cccccc,false"})
    @DisplayName("자동차 이름은 5자까지로 제한한다.")
    public void limitFiveLength(String name, boolean expected) {
        String test = "aaaaa,,bbbb";
        String[] array = test.split(",");

        assertThat(name.length() < 6).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"cccccc"})
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    public void limitFiveLengthException(String name) {
        assertThatThrownBy(() -> {
            if (name.length() > 5)
                throw new IndexOutOfBoundsException("자동차 이름은 5자를 초과할 수 없습니다.");
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
