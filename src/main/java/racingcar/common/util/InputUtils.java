package racingcar.common.util;

import java.util.Scanner;

public class InputUtils {
    private InputUtils() {}
    
    public static int getIntValue(String description) {
        System.out.println(description);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
