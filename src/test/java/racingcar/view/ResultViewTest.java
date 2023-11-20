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
        // given
        List<Car> cars = List.of(new Car(1),
                                 new Car(2),
                                 new Car(3));
        // when
        ResultView.display(cars, 1);
        // then
        assertThat(outputStreamCaptor.toString())
                .contains("실행 결과\n" +
                          "-\n" +
                          "--\n" +
                          "---");
    }
}
