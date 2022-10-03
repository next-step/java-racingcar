package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static void printQuestion(String question) {
        System.out.println(question);
    }

    private static String readAnswer(Scanner scanner) {
        return scanner.nextLine();
    }

    public static int askQuestionAnswerInt(String question) {
        printQuestion(question);
        return toInt(readAnswer(scanner));
    }

    public static String askQuestionAnswer(String question) {
        printQuestion(question);
        return readAnswer(scanner);
    }

    public static List<String> split(String text, String regex) {
        String[] splitText = text.split(regex);
        return Arrays.asList(splitText);
    }

    public static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("정수를 입력해주세요.");
        }
    }
}
