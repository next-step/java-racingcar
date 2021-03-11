package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Name;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    @DisplayName("이름은 5자를 초과할 수 없다.")
    void nameCanUnder5() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name("jhLim97");
        });
    }
}
