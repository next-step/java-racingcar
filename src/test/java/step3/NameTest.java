package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 때 IllegalArgumentException이 발생해야 한다.")
    void 자동차이름_5자초과() {
        Assertions.assertThatThrownBy(() -> {
            Name carName = new Name("racing");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
