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
    @CsvSource(value = {"'more',1", "'more,much',5", "'more,much,less',2"})
    @ParameterizedTest
    void printResultTestWithConditionChange(String namesOfCarString, int tryCount) {
        String[] namesOfCar = namesOfCarString.split(",");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream testOut = new PrintStream(outputStream);
        ResultView resultView = new ResultView(testOut);

        RacingGame racingGame = RacingGame.of(namesOfCar, tryCount, new AlwaysMove());
        RacingGameResult racingGameResult = racingGame.start();

        resultView.printResult(racingGameResult);

        String consoleOutput = outputStream.toString();
        verifyOutput(consoleOutput, namesOfCar, tryCount);
    }

    public void verifyOutput(String result, String[] namesOfCar, int tryCount) {
        String[] lines = result.split("\r\n");

        int expectedTotalLines = namesOfCar.length * tryCount;
        assertThat(lines).hasSize(expectedTotalLines + tryCount + 2);

        for (int trialIdx = 0; trialIdx < tryCount; trialIdx++) {
            verifyTrial(namesOfCar, trialIdx, lines);
        }
    }

    private static void verifyTrial(String[] namesOfCar, int trialIdx, String[] lines) {
        int numberOfCar = namesOfCar.length;

        for (int carIdx = 0; carIdx < numberOfCar; carIdx++) {
            // carIdx
            // 1 (제목)
            // (numberOfCar + 1) * trialIdx (이전 시도)
            String name = namesOfCar[carIdx];
            int lineIndex = carIdx + 1 + (numberOfCar + 1) * trialIdx;
            String line = lines[lineIndex];

            int expectedDashCount = trialIdx + 2;
            assertThat(line)
                    .hasSize(expectedDashCount + name.length() + 1)
                    .contains("-")
                    .contains(name);
        }
    }
}