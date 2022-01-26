package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @DisplayName("자동차 이름이 5자를 초과하는 경우")
    @Test
    public void exceedFiveCharacter() {
        String[] carNames = new String[3];
        carNames[0] = "one";
        carNames[1] = "two";
        carNames[2] = "threee";
        boolean flag=InputView.checkCarName(carNames);
        assertThat(flag).isEqualTo(false);
    }

    @DisplayName("자동차 이름은 5자를 초과하지 않는 경우")
    @Test
    public void belowFiveCharacter() {
        String[] carNames = new String[3];
        carNames[0] = "one";
        carNames[1] = "two";
        carNames[2] = "three";
        boolean flag=InputView.checkCarName(carNames);
        assertThat(flag).isEqualTo(true);
    }
}