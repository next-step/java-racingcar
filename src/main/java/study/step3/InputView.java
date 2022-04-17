package study.step3;

import java.util.Scanner;

public class InputView {

    static int numberOfCar;
    static int numberOfAttempt;
    private final Scanner scanner = new Scanner(System.in);

    public void configRacingcarGame() {
        System.out.println("자동차의 대수는 몇 대 인가요?");
        numberOfCar = getNumber();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        numberOfAttempt = getNumber();
        System.out.println("실행결과");
    }

    private int getNumber() {
        return scanner.nextInt();
    }
}
