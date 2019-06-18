package learn;

import java.io.ByteArrayInputStream;

public class StubSystemInputLearnTest {

    public static void stubInputStream(String input) {

        byte[] inputBytes = input.getBytes();
        System.setIn(new ByteArrayInputStream(inputBytes));
    }
}
