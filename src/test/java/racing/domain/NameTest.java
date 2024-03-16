package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racing.domain.Name.MAX_CAR_NAME_LENGTH;

class NameTest {

    @Test
    @DisplayName("이름이 " + MAX_CAR_NAME_LENGTH + "자를 초과하는 경우 IllegalArgumentException 발생")
    void constructor_name_length_exception() {

        String successName = "a".repeat(MAX_CAR_NAME_LENGTH);

        String exceptionName = "a".repeat(MAX_CAR_NAME_LENGTH + 1);

        Name success = Name.from(successName);

        assertThatThrownBy(() -> Name.from(exceptionName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 공백인 경우 IllegalArgumentException 발생")
    void constructor_name_empty_exception() {

        String exceptionName = "";

        assertThatThrownBy(() -> Name.from(exceptionName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}