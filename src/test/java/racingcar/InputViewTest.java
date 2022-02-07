package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("자동차 이름이 5자를 초과하는 경우")
    @Test
    public void exceedFiveCharacter() {
        boolean flagOne = InputView.isValidCarName("one");
        assertThat(flagOne).isEqualTo(true);
        boolean flagTwo = InputView.isValidCarName("two");
        assertThat(flagTwo).isEqualTo(true);
        boolean flagThreee = InputView.isValidCarName("threee");
        assertThat(flagThreee).isEqualTo(false);
    }

    @DisplayName("자동차 이름은 5자를 초과하지 않는 경우")
    @Test
    public void belowFiveCharacter() {
        boolean flagOne = InputView.isValidCarName("one");
        assertThat(flagOne).isEqualTo(true);
        boolean flagTwo = InputView.isValidCarName("two");
        assertThat(flagTwo).isEqualTo(true);
        boolean flagThree = InputView.isValidCarName("three");
        assertThat(flagThree).isEqualTo(true);
    }
}
