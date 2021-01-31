package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleOutputTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void printOutput() {
        // given
        Output output = new ConsoleOutput();
        String message = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

        // when
        output.println(message);

        // then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(message);
    }
}