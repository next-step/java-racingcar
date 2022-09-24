package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.exception.FiveOverNameException;

class NameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    void name_ctor_Test() {
        assertThatNoException().isThrownBy(() -> new Name("pobbi"));
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생하지 않는다.")
    void name_notOver_throwException_test() {

        assertThatNoException().isThrownBy(() -> new Name("fivee"));
    }

    @Test
    @DisplayName("자동차_이름이_5글자를_초과하면_예외가_발생한다")
    void name_overFive_throwException_test() {
        String name = "fiveOverName";

        assertThatThrownBy(() -> new Name(name))
            .isInstanceOf(FiveOverNameException.class)
            .hasMessage("자동차 이름은 5글자를 초과할 수 없습니다.");
    }


}