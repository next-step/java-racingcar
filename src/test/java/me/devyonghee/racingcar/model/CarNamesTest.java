package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("주어진 리스트 그대로 반환")
    void list() {
        //given
        List<CarName> namesGroup = Collections.singletonList(CarName.from("abc"));
        //when, then
        assertThat(CarNames.from(namesGroup).list()).containsExactlyElementsOf(namesGroup);
    }
}
