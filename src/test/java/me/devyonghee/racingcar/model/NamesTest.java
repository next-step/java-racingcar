package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("이름들")
class NamesTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Names.from(Collections.emptyList()));
        assertThatNoException().isThrownBy(() -> Names.from(Collections.singletonList(Name.from("abc"))));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_nullCollection_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Names.from(null));
    }
}
