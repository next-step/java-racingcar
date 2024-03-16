package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("이름이 5글자 초과하면 RuntimeException 발생한다.")
    void validateName() {
        //given
        String name = "nextstep";

        //when & then
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Name(name)
            );
    }
}