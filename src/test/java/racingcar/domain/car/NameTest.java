package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    @DisplayName("5글자 이하의 글자로 이름을 생성하면 정상 생성된다.")
    void createName() {
        String inputString = "엄태권";

        Name name = new Name(inputString);

        assertThat(name.getName()).isEqualTo(inputString);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null이거나 비어있는 이름이 입력될 경우 생성에 실패한다.")
    void createName_null_empty(String inputString) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(inputString))
                .withMessage("이름은 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("5글자가 초과하는 이름을 입력할 경우 생성에 실패한다.")
    void createName_5글자초과() {
        String inputString = "ServerWizard";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(inputString))
                .withMessage("이름은 5글자를 초과할 수 없습니다. 초과된 이름 : " + inputString);
    }
}
