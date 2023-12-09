package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

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
    void displayRaceTest() {
        // given & when
        ResultView.displayRace(new Car(4));
        ResultView.displayRace(new Car(2));
        ResultView.displayRace(new Car(3));
        // then
        assertThat(outputStreamCaptor.toString())
            .contains("----\n" +
                          "--\n" +
                          "---\n");
    }
}