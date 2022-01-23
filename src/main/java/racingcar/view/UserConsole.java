package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserConsole {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String ERROR_LOG = "[ERROR] ";

    public static String getConsoleTextFrom(String message) {
        try {
            System.out.println(message);
            String line = br.readLine().trim();
            return line;
        } catch (IOException e) {
            System.out.println(ERROR_LOG + e.getMessage());
            return getConsoleTextFrom(message);
        }
    }
}
