package game.view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner SC = new Scanner(System.in);

    private InputView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static String showCarNamesConsole() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SC.nextLine();
    }

    public static int showGameCountConsole() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SC.nextInt();
    }
}