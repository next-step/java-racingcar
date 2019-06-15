package step2.racing.testutil;

import java.io.*;

public class SystemInputStubUtil {

    public static void stubInputStream(String input) {

        byte[] inputBytes = input.getBytes();
        System.setIn(new ByteArrayInputStream(inputBytes));
    }
}
