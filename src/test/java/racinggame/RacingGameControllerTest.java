package racinggame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

import racinggame.racingcar.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class RacingGameControllerTest {

    @ParameterizedTest
    @CsvSource({
            "3, 1",
            "5, 1",
            "3, 2",
            "4, 3",
            "3, 5"
    })
    @DisplayName("입력받은 시도 횟수만큼 게임을 진행한다")
    void runMultipleRounds(int numberOfCars, int numberOfRounds) {
        String input = numberOfCars + "\n" + numberOfRounds + "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RacingCars racingCars = new RacingCars();
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        Race race = new Race(racingCars, moveStrategy);
        InputView inputView = new ConsoleInputView(); // 실제 구현체 사용
        ResultView resultView = new ConsoleResultView(); // 실제 구현체 사용
        RacingGameController controller = new RacingGameController(inputView, resultView, race);

        controller.run();

        assertThat(racingCars.count()).isEqualTo(numberOfCars);
        List<Integer> positions = racingCars.getCurrentPositionsRepresentation();
        for (int position : positions) {
            assertThat(position).isBetween(0, numberOfRounds);
        }
    }
}
