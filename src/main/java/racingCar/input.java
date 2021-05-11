package racingCar;

import java.util.Scanner;

public class input {
    // 자동차 이름
    public static String carName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();    }

    public static int gameNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇 회인가요?");
       return scanner.nextInt();
    }

    public static void main(String[] args) {
        String carName = carName();
        int gameNumber = gameNumber();

        System.out.println(carName);
        System.out.println(gameNumber);
    }
}
