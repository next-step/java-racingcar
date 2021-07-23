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
    @DisplayName("사용자 자동차 갯수 입력 성공 테스트")
    void 자동차_갯수_입력_성공() {

        int input = 2;
        InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);

        racing.userInputNumberOfCar();
        assertThat(racing.getCars().cars.size()).isEqualTo(input);
    }

    @Test
    @DisplayName("사용자 자동차 갯수 입력 실패 테스트(1대 입력)")
    void 자동차_갯수_입력_실패_1대입력() {
        int input = 1;
        InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> racing.userInputNumberOfCar())
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessage("2개 이상의 자동차를 입력해야 시작 가능합니다.");
    }

    @Test
    @DisplayName("사용자 게임 횟수 입력 성공 테스트")
    void 게임_횟수_입력_성공() {

        int input = 2;
        InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);

        racing.userInputNumberOfRacing();
        assertThat(racing.getRacingTime()).isEqualTo(input);
    }

    @Test
    @DisplayName("사용자 게임 횟수 입력 실패 테스트(0회 입력)")
    void 게임_횟수_입력_실패_0회입력() {
        int input = 0;
        InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> racing.userInputNumberOfRacing())
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessage("0은 입력이 불가합니다.");
    }
}
