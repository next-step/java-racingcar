package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameInitTest {

    @DisplayName("각 자동차 이름은 5글자를 초과할 수 없다.")
    @Test
    void 자동차_이름_길이_제한(){
        GameInit gameInit = new GameInit();
        List<String> names = Arrays.asList("123", "23456", "123456");
        boolean isCorrect = gameInit.lessThanMaxLength(names);
        Assertions.assertThat(isCorrect).isFalse();
    }

}