package racing;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = scanner.nextInt();

        System.out.println();
        System.out.println("실행 결과");

        String[] carPosition = new String[carCount];
        for (int i = 0; i < carCount; i++) {
            carPosition[i] = "";
        }

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < carCount; j++) {
                if (new Random().nextInt(10) >= 4) {
                    carPosition[j] += '-';
                }
                System.out.println(carPosition[j]);
            }
//            System.out.println(Arrays.toString(carPosition));
            System.out.println();
        }
    }
}
