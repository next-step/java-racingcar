package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.InputView;
import study.racingcar.ResultView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
public class RacingCarTest {

    ResultView resultView = new ResultView();
    InputView inputView = new InputView();

    @Test
    @DisplayName("사용자에게 특정 메세지를 보여주는 기능")
    void showMessage() {
        assertThat(resultView.questionMessage("TRY")).isEqualTo("시도할 회수는 몇 회 인가요?");
        assertThat(resultView.questionMessage("CAR")).isEqualTo("자동차 대수는 몇 대 인가요?");
        assertThat(resultView.questionMessage("A")).isEqualTo("NO MESSAGE");
    }

    @Test
    @DisplayName("사용자에게 숫자만 입력받는 기능")
    void systemSetInNumber() {
        InputStream inputStream = new ByteArrayInputStream("3".getBytes());
        System.setIn(inputStream);
        int result = inputView.scanNumber();
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("0에서 9사이의 random값을 구한 후 4이상일 경우 전진하는 기능")
    void forwardAndStop() {
        int number = inputView.randomNumber();
        String message = inputView.forwardAndStop(number);
        if(number >= 4) {
            assertThat(message).isEqualTo("FORWARD");
        }else {
            assertThat(message).isEqualTo("STOP");
        }
    }

    @Test
    @DisplayName("자동차의 상태가 잘 나타나는지 확인")
    void carsStatus() {
        int number = 3;
        String result = "-";
        for (int i = 0; i < number; i++) {
            result += "-";
        }
        assertThat(result).isEqualTo("----");
    }
}
