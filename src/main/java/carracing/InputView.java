package carracing;

import java.io.ByteArrayInputStream;

public class InputView {
    public static void input(String inputText) {
        ByteArrayInputStream inputTextStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputTextStream);
    }

    public static void printMessage(String startMessage) {
        System.out.println("startMessage = " + startMessage);
    }
}
