package step2.racing.testutil;

import java.io.ByteArrayInputStream;

public class InputStreamMockUtil {

    public static void mockInputStream(String input) {

        byte[] inputBytes = input.getBytes();
        System.setIn(new ByteArrayInputStream(inputBytes));
    }
}
