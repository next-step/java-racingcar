package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("이름은 5자를 초과할 수 없고 1자 이상이어야 한다.")
    void nameLength() {
        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> new Name(""));
        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> new Name("밀키스코카콜라"));
    }
}
