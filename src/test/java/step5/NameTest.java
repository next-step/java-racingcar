package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("이름이 5자를 초과하면 익셉션을 발생시킨다")
    public void 이름이_5자를_초과하면_익셉션을_발생시킨다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Name("pobimaster"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 비어있으면 익셉션을 발생시킨다")
    public void 이름이_비어있으면_익셉션을_발생시킨다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름이 비었습니다.");
    }
}
