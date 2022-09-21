package racingcar.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputViewUtil {

    public static String input(String inputMessage) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(inputMessage);

        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
