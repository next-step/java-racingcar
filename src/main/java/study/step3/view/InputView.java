package study.step3.view;

import java.util.Scanner;

public class InputView {
    public static int numberOfCars() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("경주에 참여할 자동차의 대수를 입력해주세요.");
        return scanner.nextInt();
    }

    public static int repeatCount() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("경주의 총 라운드 횟수를 입력해주세요.");
        return scanner.nextInt();
    }
}
