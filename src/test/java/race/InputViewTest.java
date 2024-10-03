package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {",", "Car1,Car2,Car3,Car4,Car5,Car6"})
    @DisplayName("입력한 자동차 대수가 범위를 초과할 경우 IllegalArgumentException 발생한다.")
    public void givenCarCountOverRange_shouldReturnIllegalArgumentException(String input) {
        Scanner scanner = new Scanner(input);
        InputView inputView = new InputView(scanner);

        assertThatThrownBy(inputView::receiveCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주 할 자동차 이름을 1~5대 사이로 입력 해 주시기 바랍니다.");
    }

    @Test
    @DisplayName("자동차 이름을 입력할 경우 자동차 이름의 리스트로 반환한다.")
    public void givenCarNames_shouldReturnCarNameList() {
        Scanner scanner = new Scanner("Car1,Car2");
        InputView inputView = new InputView(scanner);

        assertThat(inputView.receiveCarNames()).containsExactly("Car1", "Car2");
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "/", "10ad"})
    @DisplayName("경주 횟수가 숫자로 입력되지 않을 경우 NoSuchElementException이 발생한다.")
    public void givenRaceCountIsWrong_shouldReturnInputMismatchException(String input) {
        Scanner scanner = new Scanner(input);
        InputView inputView = new InputView(scanner);

        assertThatThrownBy(inputView::receiveRaceCount)
                .isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10"})
    @DisplayName("경주 횟수가 범위를 벗어날 경우 IllegalArgumentException이 발생한다.")
    public void givenRaceCountOverRange_shouldReturnIllegalArgumentException(String input) {
        Scanner scanner = new Scanner(input);
        InputView inputView = new InputView(scanner);

        assertThatThrownBy(inputView::receiveRaceCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 9 사이의 양수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "9"})
    @DisplayName("경주 횟수가 정상적으로 입력될 경우 입력된 경주 횟수를 정수로 반환한다.")
    public void givenRaceCountIsNormal_shouldReturnRaceCount(String input) {
        Scanner scanner = new Scanner(input);
        InputView inputView = new InputView(scanner);

        assertThat(inputView.receiveRaceCount()).isEqualTo(Integer.parseInt(input));
    }
}
