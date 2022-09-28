package racingcar;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NicknameTest {

    @Test
    @DisplayName("Nickname 인스턴스를 생성할 때 닉네임을 입력할 수 있다.")
    void nicknameCreate() {
        String expected = "boost";

        assertThat(new Nickname("boost").getValue()).isEqualTo(expected);
    }

    @Test
    @DisplayName("다섯자를 초과하는 닉네임은 사용하면 CanNotOverFiveCharacterNicknameException이 발생한다.")
    void nicknameMax() {

        ThrowingCallable actual = () -> new Nickname("orange");

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(CanNotOverFiveCharacterNicknameException.class)
                .hasMessage("다섯자를 초과하는 닉네임은 사용할 수 없습니다.");
    }

    @Test
    @DisplayName("null 이면 CanNotNullNicknameException이 발생한다.")
    void nicknameNull() {
        ThrowingCallable actual = () -> new Nickname(null);

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(CanNotNullNicknameException.class)
                .hasMessage("null인 인자값은 nickname이 될 수 없습니다.");
    }
}
