import racingcar.controller.NameSpliter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingGameTest {
    public NameSpliter nameSpliter = new NameSpliter();

    @DisplayName("hello,new,world split names")
    @Test
    void shouldSuccessToSplitNamesForCorrectResult(){
        String target = "hello,new,world";
        String[] result = nameSpliter.splitNames(target);
        String[] answer = {"hello", "new", "world"};
        assertThat(result).isEqualTo(answer);
    }
}