package domain.car;

import domain.car.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NameTest {
    @DisplayName("이름이 같은 Name 비교 시 참을 리턴한다")
    @Test
    void equals() {
        Name name1 = new Name("Name");
        Name name2 = new Name("Name");

        assertThat(name1).isEqualTo(name2);
    }

    @DisplayName("null or empty String은 이름으로 허용하지 않는다")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyString(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name(input))
                .withMessageMatching("유효하지 않은 이름입니다.");
    }

    @DisplayName("5자가 넘은 이름은 허용하지 않는다")
    @Test
    void nameLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name("FailName"))
                .withMessageMatching("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
