package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNameTest {

    @DisplayName("자동차는 5자 초과의 이름을 가질 수 없다.")
    @Test
    void constructor() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName("다섯글자다다"));
    }

}
