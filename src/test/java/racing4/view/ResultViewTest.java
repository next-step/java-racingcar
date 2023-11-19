package racing4.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing4.domain.Race4Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void displayGameResultTest() {
        // given
        Race4Car race4Car = new Race4Car("name");
        race4Car.moveForwardByCondition(9);
        race4Car.moveForwardByCondition(9);
        // when
        ResultView.displayGameResult(List.of(race4Car));
        // then
        assertThat(outputStreamCaptor.toString())
                .contains("name : --");
    }

    @Test
    void printWinnerTest() {
        // given
        List<String> winners = List.of("winner1", "winner2");
        // when
        ResultView.printWinner(winners);
        // then
        assertThat(outputStreamCaptor.toString())
                .contains("winner1,winner2가 최종 우승했습니다.");
    }
}
