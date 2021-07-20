package step3;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();

        int[] car = new int[carCount];

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < carCount; j++) {
                int randomNumber = random.nextInt(10);
                if (randomNumber >= 4) car[j]++;
                for (int k = 0; k < car[j]; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println("======================================");
        }
    }
}
