package step3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String numericPattern = "^\\d*$";

    public static int generateCarCnt(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        return toInt(scanner.nextLine());
    }

    public static int generateTryCnt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return toInt(scanner.nextLine());
    }

    private static int toInt(String input){
        validateNumericPattern(input);
        return Integer.parseInt(input);
    }

    private static void validateNumericPattern(String value) {
        if(!Pattern.matches(numericPattern, value)){
            throw new IllegalStateException("숫자만 입력 가능합니다.");
        }
    }
}


