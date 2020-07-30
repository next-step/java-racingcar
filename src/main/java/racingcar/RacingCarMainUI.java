package racingcar;

import java.util.Scanner;

public class RacingCarMainUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inputCount();
        racingResultDisplay();
    }

    private static Counter inputCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        final int carCount = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        final int tryCount = scanner.nextInt();

        return new Counter(carCount, tryCount);
    }

    private static void racingResultDisplay(){
        System.out.println("실행 결과");
    }
}
