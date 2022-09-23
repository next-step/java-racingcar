package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String COMMA = ",";
    private static final String DOUBLE_DOT = ":";

    public static int calculateInputText() {
        List<String> userInput = getUserInput();
        List<Integer> intList = splitText(userInput.get(0));
        Operator op = Operator.findBySymbol(userInput.get(1));
        return calculate(intList, op);
    }

    private static List<String> getUserInput() {
        System.out.print("[{text} {operator}] 순서로 입력해주세요. ex) 1,2,3 + \n" +
                "--> ");
        Scanner scanner = new Scanner(System.in).useDelimiter(" ");
        String text = scanner.next();
        String operText = scanner.nextLine().trim();
        return List.of(text, operText);
    }

    public static List<Integer> splitText(String text) {
        if (text == null || text.isEmpty())
            return List.of();
        return convertTextToIntList(text);
    }

    public static int calculate(List<Integer> intList, Operator operator) {
        if (intList.isEmpty()) {
            return 0;
        }
        int result = intList.get(0);
        for (int i = 1; i < intList.size(); i++) {
            int num = intList.get(i);
            result = operator.execute(result, num);
        }
        return result;
    }

    public static List<Integer> convertTextToIntList(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return toInts(tokens);
        }
        String[] numbers = text.split("[" + COMMA + DOUBLE_DOT + "]");
        return toInts(numbers);
    }

    private static List<Integer> toInts(String[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (String number : numbers) {
            validatePositveNumber(number);
            list.add(Integer.parseInt(number));
        }
        return list;
    }

    private static void validatePositveNumber(String number) {
        try {
            int parseNum = Integer.parseInt(number);
            if (parseNum < 0) {
                throw new RuntimeException("음수는 들어올 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 형태가 아닌 값이 존재합니다.");
        }
    }
}
