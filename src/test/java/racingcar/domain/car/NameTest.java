package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarSettingException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    @DisplayName("이름 입력 테스트")
    void 이름_입력_성공_테스트() {
        Name name = new Name("pobi");
        assertThat(name.getName()).isEqualTo("pobi");
    }
    
    @Test
    @DisplayName("이름 공백 입력 테스트")
    void 이름_공백_입력_실패_테스트() {
        assertThatThrownBy(() -> new Name(" "))
                .isInstanceOf(InvalidCarSettingException.class)
                .hasMessage("자동차 이름은 공백이 불가합니다.");
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 테스트")
    void 이름_5자_초과_입력_실패_테스트() {
        assertThatThrownBy(() -> new Name("hjjang"))
                .isInstanceOf(InvalidCarSettingException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
    
}
