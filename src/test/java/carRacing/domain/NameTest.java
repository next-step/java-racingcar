package carRacing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 이름 VO 객체 관련 테스트")
public class NameTest {
    @Test
    @DisplayName("자동차 이름이 5글자를 넘으면 에러를 던진다")
    void 자동차이름_validation_확인() {
        String text = "abcdef";
        Assertions.assertThatThrownBy(() -> new Name(text))
                .isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}
