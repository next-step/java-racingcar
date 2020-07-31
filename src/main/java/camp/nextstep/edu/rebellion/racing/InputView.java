package camp.nextstep.edu.rebellion.racing;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int getEntryNumbers() {
        System.out.print("참가할 자동차는 몇 대 입니까? ");
        if(SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("입력 값이 없거나 숫자형식이 아닙니다");
    }

    public static int getRounds() {
        System.out.print("몇 ROUND 까지 진행하시겠습니까? ");
        if(SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("입력 값이 없거나 숫자형식이 아닙니다");
    }
}

