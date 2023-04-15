package racingcar.mock;

import java.io.*;

public class InputUtil {

    public static void mockInputStream(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
