package car_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void createName() {
        // given
        String inputName = "Dodi";
        Name expectedName = new Name(inputName);

        // when
        Name name = new Name(inputName);

        // then
        assertThat(name).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("when input name's length exceeds 5, returns illegalArgumentException")
    void createName_WhenNameLengthExceed_5() {
        // given
        String inputName = "This is Long name";

        // when, then
        assertThatThrownBy(() -> new Name(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자를 초과할 수 없습니다. ");
    }

}