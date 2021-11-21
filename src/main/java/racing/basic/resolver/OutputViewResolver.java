package racing.basic.resolver;

import java.io.PrintStream;
import java.util.List;

public class OutputViewResolver {

    private static final PrintStream PRINT_STREAM = System.out;

    private static final String LINE_SYMBOL = "-";
    private static final String CONTOUR = "";

    public void sendMessage(List<Integer> messages) {
        for (int oneLine : messages) {
            String message = displayLine(oneLine);
            sendMessage(message);
        }
        sendMessage(CONTOUR);
    }

    private String displayLine(int lineLength) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < lineLength; i++) {
            line.append(LINE_SYMBOL);
        }
        return line.toString();
    }

    private void sendMessage(String message) {
        PRINT_STREAM.println(message);
    }
}
