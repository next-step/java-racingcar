package step4;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    @Test
    @DisplayName("printRacingGameWinner 메소드 동작 테스트")
    void printRacingGameWinner() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String carNames = "yongjin5184, pobi, pporotoss";

        RacingGame racingGame = RacingGame.create(() -> true);
        racingGame.readyRacingCars(carNames);
        OutputView.printRacingGameWinner(racingGame.getWinners());

        assertThat(carNames + " 가 최종 우승했습니다.\n").isEqualTo(outContent.toString());
    }
}