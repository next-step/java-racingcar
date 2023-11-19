package racing4.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing4.domain.Race4Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
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
        ResultView.displayRoundResult(List.of(race4Car));
        // then
        assertThat(outputStreamCaptor.toString())
                .contains("name : --");
    }

    @Test
    void printWinnerTest() {
        // given
        Race4Car race4Car1 = new Race4Car("name1");
        race4Car1.moveForwardByCondition(9);
        Race4Car race4Car2 = new Race4Car("name2");
        // when
        ResultView.displayWinner(Arrays.asList(race4Car1, race4Car2));
        // then
        assertThat(outputStreamCaptor.toString())
                .contains("name1가 최종 우승했습니다.");
    }
}
