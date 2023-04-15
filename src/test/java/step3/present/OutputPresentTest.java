package step3.present;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OutputPresentTest {

    ByteArrayOutputStream outputStream;
    OutputPresent outputPresent;

    @BeforeEach
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.outputStream));
        outputPresent = new OutputPresent();
    }

    @DisplayName("입력받은 경기결과대로 잘 출력한다")
    @Test
    public void printResult() {
        //given
        List<List<String>> input = List.of(
            List.of("-", "--", "--", "---", "----", "----"),
            List.of("-", "--", "--", "---", "----", "----"),
            List.of("-", "--", "--", "---", "----", "----")
        );
        String answer = "실행 결과\n" +
            "\n" +
            "-\n" +
            "-\n" +
            "-\n" +
            "\n" +
            "--\n" +
            "--\n" +
            "--\n" +
            "\n" +
            "--\n" +
            "--\n" +
            "--\n" +
            "\n" +
            "---\n" +
            "---\n" +
            "---\n" +
            "\n" +
            "----\n" +
            "----\n" +
            "----\n" +
            "\n" +
            "----\n" +
            "----\n" +
            "----";
        //when
        outputPresent.printResult(input);
        //then
        assertThat(outputStream.toString().trim()).isEqualTo(answer);
    }

    @DisplayName("우승출력 AB-TEST : 누가 우승했는지를 알려준다. 여러명일수 있다")
    @Test
    public void multiWinner() {
        //given
        List<String> input = List.of("Winner", "Manner", "Checkin", "Dinner");
        String answer = "Winner,Manner,Checkin,Dinner 가 최종 우승하였습니다";
        //when
        outputPresent.printWinner(input);
        //then
        assertThat(outputStream.toString().trim()).isEqualTo(answer);
    }

    @DisplayName("우승출력 AB-TEST : 우승했는지를 알려준다")
    @Test
    public void winnerDisplay() {
        //given
        List<String> input = List.of("Winner");
        String answer = "Winner 가 최종 우승하였습니다";
        //when
        outputPresent.printWinner(input);
        //then
        assertThat(outputStream.toString().trim()).isEqualTo(answer);
    }
}