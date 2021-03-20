package step4.domain.ipnut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNamesTest {

    @DisplayName("InputNames 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String names = "pobi,brown,json";
        InputNames expectedInputNames = new InputNames(names);

        // when
        InputNames actualInputNames = new InputNames(names);

        // then
        assertThat(actualInputNames).isEqualTo(expectedInputNames);

    }

    @DisplayName("InputNames 인스턴스에 부적절한 값을 입력시 예외처리 발생 여부 테스트")
    @Test
    void 검증() {
        // given
        List<String> name = null;

        // when and then
        assertThatThrownBy(() -> {
            new InputNames(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 사용했습니다.");

    }

    @DisplayName("InputNames 인스턴스가 포함한 값 반환 여부 테스트")
    @Test
    void 반환() {
        // given
        List<String> expected = Arrays.asList("pobi", "brown", "json");


        // when
        InputNames inputNames = new InputNames(expected);
        List<String> actual = inputNames.inputNames();

        // then
        assertThat(actual).isEqualTo(expected);
    }


}