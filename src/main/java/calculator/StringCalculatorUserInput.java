package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorUserInput {
    private static final String COMMA = ",";
    private static final String DOUBLE_DOT = ":";

    public static CalculatorComponent getUserInput() {
        printDescription();
        return createComponentByUserInput();
    }

    private static CalculatorComponent createComponentByUserInput() {
        Scanner scanner = new Scanner(System.in).useDelimiter(" ");
        try {
            String text = scanner.next();
            String operationText = scanner.nextLine().trim();
            return new CalculatorComponent(convertTextToPositiveList(text), Operator.findBySymbol(operationText));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("입력형태에 맞게 입력해주세요.");
        }
    }

    private static void printDescription() {
        System.out.print("[{text} {operator}] 순서로 입력해주세요. ex) 1,2,3 + \n" +
                         "--> ");
    }

    public static List<Positive> convertTextToPositiveList(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return toPositives(tokens);
        }
        String[] numbers = text.split("[" + COMMA + DOUBLE_DOT + "]");
        return toPositives(numbers);
    }

    private static List<Positive> toPositives(String[] numbers) {
        List<Positive> list = new ArrayList<>();
        for (String number : numbers) {
            list.add(new Positive(number));
        }
        return list;
    }
}
