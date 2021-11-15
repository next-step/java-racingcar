package racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 - TerminalInputView 단위 테스트")
class TerminalInputViewTest {

    private final InputStream stdin = System.in;
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
        System.setIn(stdin);
    }

    @Test
    @DisplayName("3단계 - 차 수 입력 기능")
    void inputNumberOfCar() {
        String data = "3";
        setUpDataInputStream(data);

        int numberOfCar = TerminalInputView.inputNumberOfCar();

        assertThat(numberOfCar).isEqualTo(3);
    }

    @Test
    @DisplayName("3단계 - 이동 횟수 입력 기능")
    void inputNumberOfMove() {
        String data = "5";
        setUpDataInputStream(data);

        int numberOfMove = TerminalInputView.inputNumberOfMove();

        assertThat(numberOfMove).isEqualTo(5);
    }

    @Test
    @DisplayName("4단계 - 자동차 이름 입력")
    void inputNamesOfCar() {
        String data = "pobi,crong,honux";
        setUpDataInputStream(data);

        List<String> names = TerminalInputView.inputNamesOfCar();

        assertThat(String.join(",", names))
                .isEqualTo(data);
    }

    private void setUpDataInputStream(String data) {
        System.setIn(
                new ByteArrayInputStream(data.getBytes()));
    }
}
