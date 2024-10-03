package racinggame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RacingGameInputViewTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @ParameterizedTest
    @CsvSource({
            "'a,b,c,d,e\n', 5, '경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).'",
            "'pobi,crong,honux\n', 3, '경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).'",
            "'carr\n', 1, '경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).'"
    })
    @DisplayName("자동차 대수를 정상적으로 입력받는다")
    void readValidNumberOfCars(String input, int expected, String expectedOutput) {
        InputStream in = new ByteArrayInputStream((input).getBytes());
        System.setIn(in);

        ConsoleInputView consoleInputView = new ConsoleInputView();
        List<String> namesOfCars = consoleInputView.readNamesOfCars();

        assertThat(namesOfCars).containsExactly(input.trim().split(","));
        assertThat(testOut.toString()).contains(expectedOutput);
    }

    @ParameterizedTest
    @CsvSource({
            "'5\n', 5, '시도할 회수는 몇 회 인가요?'",
            "'10\n', 10, '시도할 회수는 몇 회 인가요?'",
            "'1\n', 1, '시도할 회수는 몇 회 인가요?'"
    })
    @DisplayName("시도 횟수를 정상적으로 입력받는다")
    void readValidNumberOfRounds(String input, int expected, String expectedOutput) {
        InputStream in = new ByteArrayInputStream((input).getBytes());
        System.setIn(in);

        ConsoleInputView consoleInputView = new ConsoleInputView();
        int numberOfRounds = consoleInputView.readNumberOfRounds();

        assertThat(numberOfRounds).isEqualTo(expected);
        assertThat(testOut.toString()).contains(expectedOutput);
    }

    @ParameterizedTest
    @DisplayName("5자 이상의 이름을 입력하면 재입력을 요구한다")
    @ValueSource(strings = {"abcdef\n", "longname\n"})
    void readInvalidCarNames(String input) {
        String validInput = "pobi,crong\n";
        InputStream in = new ByteArrayInputStream((input + validInput).getBytes());
        System.setIn(in);

        ConsoleInputView consoleInputView = new ConsoleInputView();
        List<String> namesOfCars = consoleInputView.readNamesOfCars();

        assertThat(namesOfCars).containsExactly("pobi", "crong");
        assertThat(testOut.toString()).contains("자동차 이름은 5자 이하여야 합니다");
    }

    @ParameterizedTest
    @DisplayName("시도 횟수에 음수나 0을 입력하면 재입력을 요구한다")
    @ValueSource(strings = {"-1\n", "0\n"})
    void readInvalidNumberOfRounds(String input) {
        String validInput = "3\n";
        InputStream in = new ByteArrayInputStream((input + validInput).getBytes());
        System.setIn(in);

        ConsoleInputView consoleInputView = new ConsoleInputView();
        int numberOfRounds = consoleInputView.readNumberOfRounds();

        assertThat(numberOfRounds).isEqualTo(3);
        assertThat(testOut.toString()).contains("양수를 입력해주세요");
    }

    @Test
    @DisplayName("시도 횟수에 문자열을 입력하면 재입력을 요구한다")
    void readInvalidStringInputForRounds() {
        String invalidInput = "xyz\n";
        String validInput = "3\n";
        InputStream in = new ByteArrayInputStream((invalidInput + validInput).getBytes());
        System.setIn(in);

        ConsoleInputView consoleInputView = new ConsoleInputView();
        int numberOfRounds = consoleInputView.readNumberOfRounds();

        assertThat(numberOfRounds).isEqualTo(3);
        assertThat(testOut.toString()).contains("숫자를 입력해주세요");
    }
}
