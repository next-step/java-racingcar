package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameTest {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    @Test
    void 이름_조건_부합_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name("aasjdflk")).withMessage("[ERROR] 이름의 길이는 " + CAR_NAME_MIN_LENGTH + " ~ " + CAR_NAME_MAX_LENGTH
                + " 글자 까지만 가능합니다.");
    }
}