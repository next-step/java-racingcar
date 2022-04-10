import racingcar.Printer;
import racingcar.RacingCar;

import java.util.Random;
import java.util.Scanner;

public class RacingController {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("레이싱에 참여할 자동차 대수를 입력해주세요.");
        int countOfCar = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 번인가요?");
        int maxAttempts = scanner.nextInt();

        int[] cars = new int[countOfCar];

        System.out.println("실행 결과");

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            for (int carIndex = 0; carIndex < cars.length; carIndex++) {
                cars[carIndex] += RacingCar.move(new Random().nextInt(10));
                Printer.print(cars[carIndex]);
            }
            System.out.println("<----------> 회차종료");
        }
    }
}
