package fifthrefactoring.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private InputView inputview = new InputView();
    private String systemInStringValue = "";
    private int systemInIntValue = 0;

    @ParameterizedTest
    @ValueSource(strings = "pobi")
    @DisplayName("자동차 입력값 테스트")
    void carNameInputTest(String testInput) {
        systemInStringValue = "pobi";
        System.setIn(new ByteArrayInputStream(systemInStringValue.getBytes()));
        String carNameInput =
                inputview.inputCarName();
        assertThat(carNameInput).isEqualTo(testInput);
    }

    @ParameterizedTest
    @ValueSource(ints = 5)
    @DisplayName("시도회수 입력값 테스트")
    void tryNoInputTest(int testInput) {
        systemInIntValue = 5;
        System.setIn(new ByteArrayInputStream(String.valueOf(systemInIntValue).getBytes()));
        int tryNoInput = inputview.inputTryNumber();
        assertThat(tryNoInput).isEqualTo(testInput);
    }
}