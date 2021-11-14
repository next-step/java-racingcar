package racing.basic.resolver;

import java.io.PrintStream;

public class OutputViewResolver {

    private static final PrintStream PRINT_STREAM = System.out;

    private static final String LINE_SYMBOL = "-";
    private static final String CONTOUR = "";

    public void sendMessage(String message) {
        PRINT_STREAM.println(message);
    }

    public void sendMessage(int[] array) {
        for (int oneLine : array) {
            String line = displayLine(oneLine);
            PRINT_STREAM.println(line);
        }
        PRINT_STREAM.println(CONTOUR);
    }

    private String displayLine(int lineLength) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < lineLength; i++) {
            line.append(LINE_SYMBOL);
        }
        return line.toString();
    }
}
