package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NameTest {

    @Test
    @DisplayName("[성공] 자동차는 5자 이하의 이름을 부여해야 한다.")
    void 자동차_이름_성공() {
        assertDoesNotThrow(() -> {
            new Name("pobi");
        });
    }

    @Test
    @DisplayName("[실패] 5자 이상의 자동차 이름이 부여된 경우 NameLengthExceededException 이 발생한다.")
    void 자동차_이름_실패() {
        Assertions.assertThatThrownBy(() -> {
            new Name("nayeon");
        }).isInstanceOf(NameLengthExceededException.class)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

}
