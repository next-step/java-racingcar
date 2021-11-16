package racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.CarRacingGame;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 - TerminalOutputView 단위 테스트")
class TerminalOutputViewTest {

    private final PrintStream stdout = System.out;
    private OutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(stdout);
    }

    @Test
    @DisplayName("자동차 상태 출력 기능")
    void printCars() {
        List<String> carNames = Arrays.asList("pobi", "crong");
        int numberOfMove = 3;
        CarRacingGame carRacingGame = new CarRacingGame(carNames, numberOfMove);

        printTerminalOutput(carRacingGame);

        int carSize = carNames.size();
        String[] lines = outputStream.toString()
                .split(lineSeparator());
        assertThat(lines.length)
                .isEqualTo((carSize + 1) * numberOfMove);
    }

    private void printTerminalOutput(CarRacingGame carRacingGame) {
        TerminalOutputView.printStartSentence();

        while (carRacingGame.isPossibleToMove()) {
            carRacingGame.moveCars();
            TerminalOutputView.printCars(
                    carRacingGame.getCars());
        }
    }

    @Test
    @DisplayName("4단계 - 자동차 우승자 출력")
    void printWinnerCars() {
        List<String> carNames = Arrays.asList("pobi", "crong");
        CarRacingGame carRacingGame = new CarRacingGame(carNames, 0);

        TerminalOutputView.printWinnersCars(
                carRacingGame.extractWinners());

        assertThat(outputStream.toString())
                .contains("pobi")
                .contains("crong");
    }
}

