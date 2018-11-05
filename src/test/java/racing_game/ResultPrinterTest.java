package racing_game;

import org.junit.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultPrinterTest {

    @Test
    public void 출력잘되는지_확인() {
        MockPrintStream mockPrintStream = new MockPrintStream(System.out);
        ResultPrinter resultPrinter = new ResultPrinter(mockPrintStream);

        resultPrinter.print(3);
        String inputString = mockPrintStream.getInputString();

        assertThat(inputString).isEqualTo("---");
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