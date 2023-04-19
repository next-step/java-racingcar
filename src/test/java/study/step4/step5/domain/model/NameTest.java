package study.step4.step5.domain.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step5.domain.model.Name;
import study.step5.exception.NameMaxLengthException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"jayden", "zuly.typark"})
    public void 자동차_이름실패테스트(String inputName) {
        //given

        assertThatThrownBy(() -> {
            new Name(inputName);
        }).isInstanceOf(NameMaxLengthException.class)
                .hasMessageContaining("이름이 5 글자 이상입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"coby", "cozi"})
    public void 자동차_이름성공테스트(String inputName) {
        //given
        Name name = new Name(inputName);
        assertThat(name.getName()).isEqualTo(inputName);
    }
}
