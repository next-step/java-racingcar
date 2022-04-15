package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("자동차 이름들 생성")
class CarNamesTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> CarNames.from(Collections.singletonList(CarName.from("abc"))));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_emptyCollection_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> CarNames.from(null));
        assertThatIllegalArgumentException().isThrownBy(() -> CarNames.from(Collections.emptyList()));
    }
}
