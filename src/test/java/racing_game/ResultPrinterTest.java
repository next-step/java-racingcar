package racing_game;

import org.junit.Before;
import org.junit.Test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultPrinterTest {

    private MockPrintStream mockPrintStream;
    private ResultPrinter resultPrinter;

    @Before
    public void setup() {
        this.mockPrintStream = new MockPrintStream(System.out);
        this.resultPrinter = new ResultPrinter(mockPrintStream);
    }

    @Test
    public void 현재상태_출력_확인() {
        final String carName = "pobi";
        final TestCar testCar = new TestCar(carName, 3);

        this.resultPrinter.printCurrentState(Arrays.asList(testCar));

        String inputString = mockPrintStream.getInputString();
        assertThat(inputString).isEqualTo(carName + " : " + "---");
    }

    @Test
    public void 게임결과_출력_확인() {
        final String user1 = "pobi";
        final String user2 = "cron";
        final List<String> winnerNames = Arrays.asList(user1, user2);

        resultPrinter.printGameResult(winnerNames);

        String inputString = mockPrintStream.getInputString();
        assertThat(inputString).isEqualTo(user1 + ", " + user2 + "가 최종 우승했습니다.");
    }

    private static class MockPrintStream extends PrintStream {

        private String inputString;

        public MockPrintStream(OutputStream out) {
            super(out);
        }

        @Override
        public void println(String x) {
            this.inputString = x;
        }

        public String getInputString() {
            return inputString;
        }
    }

}