package step4_winner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CarRacingWinnerTest {

    private final InputStream stdIn = System.in;
    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpPrintStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreSystemIn() {
        System.setIn(stdIn);
        System.setOut(stdOut);
    }

    @Test
    @DisplayName("Input Test")
    void CarRacingWinnerInputTest() {
        // GIVEN 1번만 시도
        provideInput("a,b,c,d,e,f,g", "1");

        // WHEN
        CarRacingWinner.main(new String[]{});

        // THEN
        String outputStreamCaptorString = outContent.toString();
        String raceResult = outputStreamCaptorString.split("\n실행 결과\n", 2)[1];

        long linesCount = raceResult.lines().count();
        assertThat(linesCount).isEqualTo(9L);

        long emptyLinesCount = raceResult.lines().filter(String::isEmpty).count();
        assertThat(emptyLinesCount).isEqualTo(1L);

    }

    @Test
    @DisplayName("입력된 값이 없으면 NoSuchElementException")
    void throwNoSuchElementExceptionIfNoInput() {
        // GIVEN
        provideInput("", "");

        // WHEN
        Throwable IllegalThrown = catchThrowable(() -> CarRacingWinner.main(new String[]{}));

        // THEN
        assertThat(IllegalThrown)
                .isInstanceOf(NoSuchElementException.class);
    }

    private void provideInput(String... strings) {
        String inputStr = String.join("\n", strings);
        System.setIn(new ByteArrayInputStream(inputStr.getBytes(UTF_8)));
    }
}