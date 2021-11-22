package carracing;

import carracing.domain.Name;
import carracing.exception.CarNameFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("자동차 이름 5자 초과시 에러")
    void carNameValid() {
        assertThatThrownBy(() -> {
            new Name("abcdef");
        }).isInstanceOf(CarNameFormatException.class);
    }

    @Test
    @DisplayName("자동차 이름 공백 에러")
    void carNameEmptyErr() {
        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(CarNameFormatException.class);
    }
}
