package step2;

import java.util.Scanner;

public class CarRaceApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numberOfTrial = scanner.nextInt();

        System.out.println();
        System.out.println("실행 결과");
    }
}
