package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import race.view.InputView;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {",", "Car1,Car2,Car3,Car4,Car5,Car6"})
    public void 입력한_자동차_대수가_범위를_초과할_경우_IllegalArgumentException이_발생한다(String input) {
        Scanner scanner = new Scanner(input);
        InputView inputView = new InputView(scanner);

        assertThatThrownBy(inputView::receiveCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 1~5대까지 입력 가능합니다.");
    }

    @Test
    public void 자동차_이름을_입력할_경우_자동차_이름의_리스트로_반환한다() {
        Scanner scanner = new Scanner("Car1,Car2");
        InputView inputView = new InputView(scanner);

        assertThat(inputView.receiveCarNames()).containsExactly("Car1", "Car2");
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "/", "10ad"})
    public void 경주_횟수가_숫자로_입력되지_않을_경우_NoSuchElementException이_발생한다(String input) {
        Scanner scanner = new Scanner(input);
        InputView inputView = new InputView(scanner);

        assertThatThrownBy(inputView::receiveRaceCount)
                .isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10"})
    public void 경주_횟수가_범위를_벗어날_경우_IllegalArgumentException이_발생한다(String input) {
        Scanner scanner = new Scanner(input);
        InputView inputView = new InputView(scanner);

        assertThatThrownBy(inputView::receiveRaceCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 9 사이의 양수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "9"})
    public void 경주_횟수가_정상적으로_입력될_경우_입력된_경주_횟수를_정수로_반환한다(String input) {
        Scanner scanner = new Scanner(input);
        InputView inputView = new InputView(scanner);

        assertThat(inputView.receiveRaceCount()).isEqualTo(Integer.parseInt(input));
    }

}
