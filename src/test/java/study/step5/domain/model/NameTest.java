package study.step5.domain.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"jayden", "zuly.typark"})
    public void 자동차_이름테스트(String inputName) {
        //given

        assertThatThrownBy(() -> {
            new Name(inputName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 다섯자 이상입니다.");
    }
}
