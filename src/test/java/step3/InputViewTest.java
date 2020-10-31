package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게입 환경 입력 테스트")
public class InputViewTest {

    @DisplayName("자동차 대수 입력")
    @Test
    public void getCarCount() {
        InputView inputView = new InputView(new Scanner("3"), new PrintWriter(System.out));

        Integer carCount = inputView.getCarCountFromInput();
        assertThat(carCount).isEqualTo(3);
    }

    @DisplayName("자동차 대수 입력시 질의 문구")
    @Test
    public void getMessageForCarCount() {
        StringWriter output = new StringWriter();
        InputView inputView = new InputView(new Scanner("3"), new PrintWriter(output));

        inputView.getCarCountFromInput();

        assertThat(output.toString()).isEqualTo("자동차 대수는 몇 대 인가요?\n");
    }

    @DisplayName("시도 횟수 입력")
    @Test
    public void getTryCount() {
        InputView inputView = new InputView(new Scanner("5"), new PrintWriter(System.out));

        Integer carCount = inputView.getTryCountFromInput();
        assertThat(carCount).isEqualTo(5);
    }

    @DisplayName("시도 횟수 입력시 질의 문구")
    @Test
    public void getMessageForTryCount() {
        StringWriter output = new StringWriter();
        InputView inputView = new InputView(new Scanner("3"), new PrintWriter(output));

        inputView.getTryCountFromInput();

        assertThat(output.toString()).isEqualTo("시도할 회수는 몇 회 인가요?\n");
    }
}