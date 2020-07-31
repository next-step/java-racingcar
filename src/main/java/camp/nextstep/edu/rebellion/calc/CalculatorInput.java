package camp.nextstep.edu.rebellion.calc;

import java.util.Scanner;

public class CalculatorInput {
    private static final Scanner SCANNER = new Scanner(System.in);

    private CalculatorInput() {}

    public static String getExpression() {
        System.out.print("수식을 입력해 주세요 (+,-,*,/ 만 지원하며 공백으로 구분해야 합니다) (ex) 2 + 3 * 4 / 2 : ");
        if(SCANNER.hasNextLine()) {
            return SCANNER.nextLine();
        }
        throw new IllegalArgumentException("입력 값이 없습니다");
    }
}
