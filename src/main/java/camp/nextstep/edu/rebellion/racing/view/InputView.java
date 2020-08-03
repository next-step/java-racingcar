package camp.nextstep.edu.rebellion.racing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String getCarNames() {
        System.out.print("참가할 자동차 이름을 입력해주세요 (이름은 쉼표로 구분됩니다) ");
        if (SCANNER.hasNextLine()) {
           return SCANNER.nextLine().trim();
        }
        throw new IllegalArgumentException("입력 값이 없습니다");
    }

    public static int getRounds() {
        System.out.print("몇 ROUND 까지 진행하시겠습니까? ");
        if (SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("입력 값이 없거나 숫자형식이 아닙니다");
    }
}
