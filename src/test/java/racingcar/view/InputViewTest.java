package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    InputView inputView;
    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("이름을 입력하지 않으면 에러 반환")
    void throwExceptionNoInput(String empty) {
        assertThatThrownBy(() -> inputView.getCarNameArray(empty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어있을 수 없습니다");
    }

    @Test
    @DisplayName("쉼표로 구분하여 String 배열 반환")
    void splitCarNamesTest() {
        String[] carNameArray = inputView.getCarNameArray("pobi,crong,honux");
        assertThat(carNameArray).containsExactly("pobi", "crong", "honux")
                .hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi11,crong,honux", "hahahohoho,hahahihihi,hahahuhuhu", "a,b,cccccc"})
    @DisplayName("자동차 이름이 5글자 이상이면 에러 반환")
    void validateLengthOfCarName(String input) {
        assertThatThrownBy(() -> inputView.getCarNameArray(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다섯 글자 이하");
    }

}