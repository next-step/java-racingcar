package game;

import java.util.Scanner;

public final class InputView {

    private InputView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static RacingOptions showAndGetOptions() {
        Scanner sc = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int repCount = sc.nextInt();

        return new RacingOptions(carCount, repCount);
    }
}