package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PromptTest {

    @Test
    void carNameIsOver5Given_ShouldException() {
        // TODO(jack.comeback) : ExceptionCode에 추가, CustomException 추가
        assertThatThrownBy(() -> Prompt.ask("abcdfeg,abc"))
                .hasMessage("자동차 이름은 5자 이내여야 합니다.")
                .isInstanceOf(Exception.class);
    }

    @Test
    void carNameIsUnder6Given_ShouldKeepNextLogic() {

    }
}
