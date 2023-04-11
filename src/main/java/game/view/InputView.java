package game.view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner SC = new Scanner(System.in);

    private InputView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static int showAndGetCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SC.nextInt();
    }

    public static int showAndGetRacingRep() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SC.nextInt();
    }
}