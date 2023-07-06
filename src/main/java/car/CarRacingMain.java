package car;

import java.util.Scanner;

public class CarRacingMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new CarRacingGame(getCarNames()).play(getPlayCount());
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private static int getPlayCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }
}
