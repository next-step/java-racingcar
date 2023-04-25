package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarNameException;

@DisplayName("Name 객체 테스트")
public class NameTest {

    @Test
    void 자동차_이름_유효성_테스트() {
        Assertions.assertThatThrownBy(() -> new Name("abcdefg"))
                .isInstanceOf(InvalidCarNameException.class)
                .hasMessage("자동차 이름은 5자를 초과 할 수 없습니다");
    }
}
