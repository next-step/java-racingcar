import racingcar.controller.NameSpliter;
import racingcar.controller.NameChecker;
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

    @DisplayName("hello,javajava 길이 5를 초과하는 이름")
    @Test
    void errorTest(){
        String[] target = {"hello", "javajava"};
        assertThatThrownBy(() -> {
            NameChecker.checkNames(target);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자 이상의 차 이름이 포함되어있습니다.");
    }
}