package domain;

import movingStrategy.AlwaysMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ui.ResultView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class ResultViewTest {

    @DisplayName("조건 변화에 따른 경기 결과 출력 테스트")
    @CsvSource(value = {"{},1", "{},5", "{},2", "{},3"})
    @ParameterizedTest
    void printResultTestWithConditionChange(String[] namesOfCar, int numberOfTrial) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(outputStream);
        ResultView resultView = new ResultView(testOut);

        RacingGame racingGame = new RacingGame(namesOfCar, numberOfTrial, new AlwaysMove());
        RacingGameResult racingGameResult = racingGame.gameStart();

        resultView.printResult(racingGameResult);

        String consoleOutput = outputStream.toString();
        verifyOutput(consoleOutput, namesOfCar.length, numberOfTrial);
    }

    public void verifyOutput(String result, int numberOfCar, int numberOfTrial) {
        String[] lines = result.split("\r\n");

        int expectedTotalLines = numberOfCar * numberOfTrial;
        assertThat(lines).hasSize(expectedTotalLines + numberOfTrial);

        for (int trialIdx = 0; trialIdx < numberOfTrial; trialIdx++) {
            verifyTrial(numberOfCar, trialIdx, lines);
        }
    }

    private static void verifyTrial(int numberOfCar, int trialIdx, String[] lines) {
        for (int carIdx = 0; carIdx < numberOfCar; carIdx++) {
            // carIdx
            // 1 (제목)
            // (numberOfCar + 1) * trialIdx (이전 시도)
            int lineIndex = carIdx + 1 + (numberOfCar + 1) * trialIdx;
            String line = lines[lineIndex];

            int expectedDashCount = trialIdx + 2;
            assertThat(line).hasSize(expectedDashCount).contains("-");
        }
    }

}