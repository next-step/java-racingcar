package racing.view;

import racing.msg.SystemMention;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static int CNT;
    private static final Scanner sc = new Scanner(System.in);

    public int inputCntOfCar() {
        String cntOfCar = sc.nextLine();
        while (!checkInputNumber(cntOfCar)) {
            cntOfCar = sc.nextLine();
        }
        return CNT;
    }

    private boolean checkInputNumber(String input) {
        if (isNull(input)) {
            return false;
        }
        if (!isNumber(input)) {
            return false;
        }
        if (!isPositive()) {
            return false;
        }
        return true;
    }

    private boolean isNull(String input) {
        if (input == null || input.isBlank()) {
            SystemMention.NULL_CHECK.printMention();
            return true;
        }
        return false;
    }

    private boolean isNumber(String input) {
        Matcher matcher = NUMBER_PATTERN.matcher(input);
        if (matcher.find()) {
            CNT = Integer.parseInt(matcher.group());
            return true;
        }
        SystemMention.NUMBER_CHECK.printMention();
        return false;
    }

    private boolean isPositive() {
        if (CNT > 0) {
            return true;
        }
        SystemMention.POSITIVE_CHECK.printMention();
        return false;
    }
}
