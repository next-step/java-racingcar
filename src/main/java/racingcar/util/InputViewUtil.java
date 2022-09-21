package racingcar.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputViewUtil {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private InputViewUtil() {
    }

    public static String input(String inputMessage) {
        System.out.print(inputMessage);

        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
