package carRacing.view;

import carRacing.utils.StringUtils;
import com.google.common.base.Strings;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static String[] inputRaceCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        verifyInputString(input);
        return StringUtils.sptingSplitByComma(input);
    }

    private static void verifyInputString(String input) {
        if(Strings.isNullOrEmpty(input)) {
            throw new InputMismatchException("공백을 입력할 수 없습니다. 자동차명을 (,)를 기준으로 입력해야 합니다.");
        }
    }

    public static int inputNumberOfLaps() {
        System.out.println("시도핧 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
