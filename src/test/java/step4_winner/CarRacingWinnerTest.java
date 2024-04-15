package step4_winner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;

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

    @ParameterizedTest
    // GIVEN
    @ValueSource(strings = {"test1,test2,test3", "a,b,c,d,e,f,g"})
    @DisplayName("전달받은 자동차 리스트로 Input 테스트")
    void CarRacingWinnerInputTest(String input) {
        // GIVEN
        provideInput(input,"1");

        // WHEN
        CarRacingWinner.main(new String[]{});

        // THEN
        String outputStreamCaptorString = outContent.toString();
        String raceResult = outputStreamCaptorString.split("\n실행 결과\n", 2)[1];
        System.out.println(raceResult);

    }

    private void provideInput(String... strings) {
        String inputStr = String.join("\n", strings);
        System.setIn(new ByteArrayInputStream(inputStr.getBytes(UTF_8)));
    }
}