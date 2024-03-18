package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Name;
import racingcar.exception.NameLengthExceededException;

import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NameTest {

    @Test
    @DisplayName("[성공] 3글자 자동차 이름을 부여한다.")
    void 자동차_이름_성공() {
        assertDoesNotThrow(() -> {
            new Name("pobi");
        });
    }

    @Test
    @DisplayName("[성공][경계값] 5글자 자동차 이름을 부여한다.")
    void 자동차_이름_경계값_기준미만() {
        assertDoesNotThrow(() -> {
            new Name("crong");
        });
    }

    @Test
    @DisplayName("[실패][경계값] 6자의 자동차 이름을 부여한 경우 NameLengthExceededException 이 발생한다.")
    void 자동차_이름_실패_경계값_기준초과() {
        String name = "nayeon";
        assertThatThrownBy(() -> {
            new Name(name);
        }).isInstanceOf(NameLengthExceededException.class)
                .hasMessage(MessageFormat.format("자동차 이름은 5자를 초과할 수 없습니다. (적합하지 않은 자동차 이름: {0})", name));
    }

}
