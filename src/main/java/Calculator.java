import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculator {

    public int plus(String input) {
        String[] split = input.split(" ");

        int result = 0;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.equalsIgnoreCase("+")) {
                result += Integer.parseInt(split[i-1]) + Integer.parseInt(split[i+1]);
            }
        }
        return result;
    }
}
