package racingcar;

import java.util.Scanner;

public class RacingGameTestDrive {
    public static void main(String[] args) {
        int carNumber, moveNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carNumber = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        moveNumber = scanner.nextInt();
        System.out.println("실행 결과");
        RacingGame.race(carNumber, moveNumber);
    }
}
