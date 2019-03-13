package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int getIntegerValue(String question, Scanner scanner) {
        System.out.print(question);
        readInteger(scanner);
        return scanner.nextInt();
    }

    public static List<String> getStringArray(String question, String regex, Scanner scanner) {
        System.out.println(question);
        readString(scanner);
        String str = scanner.nextLine();
        return Arrays.asList(str.split(regex));
    }

    private static void readInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("숫자를 입력하세요> ");
        }
    }

    private static void readString(Scanner scanner) {
        while (!scanner.hasNext()) {
            scanner.next();
            System.err.print("자동차 이름 입력하세요> ");
        }
    }
}
