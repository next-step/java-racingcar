package step4.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String numericPattern = "^\\d*$";

    public static String inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
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


