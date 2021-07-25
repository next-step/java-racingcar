package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidUserInputException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    Racing racing = new Racing();

    @Test
    @DisplayName("사용자 게임 횟수 입력 성공 테스트")
    void 게임_횟수_입력_성공() {

        int input = 2;
        InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);

        racing.setUserInputCountOfRacing();
        assertThat(racing.getRacingTime()).isEqualTo(input);
    }

    @Test
    @DisplayName("사용자 게임 회수 입력 실패 테스트(음수 입력)")
    void 게임_회수_입력_실패_음수입력() {
        int input = -1;
        InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> racing.setUserInputCountOfRacing())
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessage("1회 이상의 게임 횟수를 입력해야 시작 가능합니다.");
    }

    @Test
    @DisplayName("사용자 게임 횟수 입력 실패 테스트(0 입력)")
    void 게임_횟수_입력_실패_0입력() {
        int input = 0;
        InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> racing.setUserInputCountOfRacing())
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessage("1회 이상의 게임 횟수를 입력해야 시작 가능합니다.");
    }
}
