package step4.domain.ipnut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNamesTest {

    @DisplayName("InputNames 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String names = "pobi,brown,json";

        // when
        InputNames inputNames = new InputNames(names);

        // then
        assertThat(inputNames).isNotNull();

    }

    @DisplayName("InputNames 인스턴스에 부적절한 값을 입력시 예외처리 발생 여부 테스트")
    @Test
    void 검증() {
        // given
        String name = "";

        // when and then
        assertThatThrownBy(() -> {
            new InputNames(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 사용했습니다.");

    }


}