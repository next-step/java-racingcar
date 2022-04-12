package racingcar;

import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        start();
    }

    public static String start() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numOfCar = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numOfGame = scanner.nextInt();

        return "";
    }
}
