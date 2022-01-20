package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameInitTest {

    @DisplayName("각 자동차 이름은 5글자를 초과할 수 없다.")
    @Test
    public void validationPlayerNameLength() {
        GameInit gameInit = new GameInit();
        String[] strings = {"abcdef"};
        boolean isCorrect = gameInit.validationStringLength(strings);
        Assertions.assertThat(isCorrect).isFalse();
    }

}