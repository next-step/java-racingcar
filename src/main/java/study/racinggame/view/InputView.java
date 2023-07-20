package study.racinggame.view;

import java.util.Scanner;

public class InputView {
    public static String carNames() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차의 이름을 입력해주세요. (이름은 쉼표(,)를 기준으로 구분하며 5자를 초과할 수 없습니다.)");
        return scanner.nextLine();
    }

    public static int repeatCount() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("경주의 총 라운드 횟수를 입력해주세요.");
        return scanner.nextInt();
    }
}
