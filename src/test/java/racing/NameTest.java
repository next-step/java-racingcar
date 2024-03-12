package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("이름이 5자를 초과하는 경우 IllegalArgumentException 발생")
    void constructor() {
        String successName = "abcde";
        String exceptionName = "abcdef";

        Name success = new Name(successName);

        assertThatThrownBy(() -> new Name(exceptionName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}