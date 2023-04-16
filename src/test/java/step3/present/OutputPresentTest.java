package step3.present;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Car;
import step3.model.Result;

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
        List<DisplayRaceVO> input = List.of(
            new DisplayRaceVO(new Result(List.of("-", "--", "--", "---", "----", "----")), new Car("hello")),
            new DisplayRaceVO(new Result(List.of("-", "--", "--", "---", "----", "----")), new Car("groot")),
            new DisplayRaceVO(new Result(List.of("-", "--", "--", "---", "----", "----")), new Car("java"))
        );
        String answer = "실행 결과\n" +
            "\n" +
            "hello : -\n" +
            "groot : -\n" +
            "java : -\n" +
            "\n" +
            "hello : --\n" +
            "groot : --\n" +
            "java : --\n" +
            "\n" +
            "hello : --\n" +
            "groot : --\n" +
            "java : --\n" +
            "\n" +
            "hello : ---\n" +
            "groot : ---\n" +
            "java : ---\n" +
            "\n" +
            "hello : ----\n" +
            "groot : ----\n" +
            "java : ----\n" +
            "\n" +
            "hello : ----\n" +
            "groot : ----\n" +
            "java : ----";
        //when
        outputPresent.printResult(input);
        //then
        assertThat(outputStream.toString().trim()).isEqualTo(answer);
    }

    @DisplayName("우승출력 TEST : 여러명이 우승했을때는 우승한 여러명 모두를 출력한다")
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

    @DisplayName("우승출력 TEST : 단독우승시 한명만 출력된다")
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