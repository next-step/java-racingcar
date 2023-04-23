package carracing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1. 자동차 이름들을  ","로 구분한다.
 */
class InputViewTest {
    @DisplayName("자동차 이름들을 ,로 구분하여 pobi, conan을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "conan"})
    void inputValue(String result) {
        InputView inputView = new InputView("pobi,conan", 3);
        assertTrue(inputView.getNames().contains(result));
    }

}