package edu.nextstep.camp.testUtils;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class TestUtils {

    private TestUtils(){
    }

    public static void systemSetIn(String inputString) {
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
    }
}
