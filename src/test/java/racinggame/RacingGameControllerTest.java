package racinggame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

import racinggame.racingcar.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RacingGameControllerTest {

    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "5, 3",
            "4, 4",
            "3, 2",
            "2, 6"
    })
    @DisplayName("입력받은 자동차 수와 시도 횟수만큼 게임을 진행한다")
    void runMultipleRounds(int numberOfCars, int numberOfRounds) {
        String input = numberOfCars + "\n" + numberOfRounds + "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MoveStrategy moveStrategy = new RandomMoveStrategy();
        InputView inputView = new ConsoleInputView();
        ResultView resultView = new ConsoleResultView();
        RacingGameController controller = new RacingGameController(inputView, resultView, moveStrategy);

        controller.run();

        String output = outputStream.toString();
        String[] lines = output.split("\n");

        assertThat(lines).contains("실행 결과");

        List<String> resultLines = Arrays.stream(lines)
                .dropWhile(line -> !line.equals("실행 결과"))
                .skip(1)
                .filter(line -> !line.trim().isBlank())
                .collect(Collectors.toList());

        int actualRounds = resultLines.size() / numberOfCars;

        assertThat(actualRounds).isEqualTo(numberOfRounds);

        for (int i = 0; i < numberOfRounds; i++) {
            List<String> roundResults = resultLines.subList(i * numberOfCars, (i + 1) * numberOfCars);

            assertThat(roundResults).hasSize(numberOfCars);

            for (String result : roundResults) {
                int position = result.length();
                assertThat(position).isBetween(1, numberOfRounds + 1);
            }
        }
    }
}
