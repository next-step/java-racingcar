package racing.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.CarRacing;
import racing.car.RandomMovableRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultViewTest {
    // 참고 : https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private ResultView resultView;
    private CarRacing carRacing;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        List<String> names = Arrays.asList("lee", "hong", "kim");

        resultView = new ResultView();
        carRacing = new CarRacing(names, 3, new RandomMovableRule());
        carRacing.run();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    @DisplayName("3번의 레이스 결과 출력하는지 확인")
    void printResult() {
        // when
        resultView.printResult(carRacing);

        // then
        assertTrue(outContent.toString().contains("RACE :: 1"));
        assertTrue(outContent.toString().contains("RACE :: 2"));
        assertTrue(outContent.toString().contains("RACE :: 3"));
    }

}