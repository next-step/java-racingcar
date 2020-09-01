package racing.view;

import racing.util.StringUtil;
import racing.util.Validator;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    static Scanner scan = new Scanner(System.in);

    public static int getRacingCarInput() {
        System.out.println("자동차 대수는 몇대 인가요?(이름은 쉼표(,)기준으로 구분)");
        return Integer.parseInt(scan.nextLine());
    }

    public static String[] getRacingCarInputWithName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,  )기준으로 구분).");
        String inputStr  = scan.nextLine();
        return Validator.validate(StringUtil.split(inputStr));
    }

    public static int getRacingInput() {
        System.out.println("시도할 횟수는 몇회 인가요?");
        return Integer.parseInt(scan.nextLine());
    }


}
