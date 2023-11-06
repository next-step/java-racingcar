package racing;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int[] carCount = new int[scanner.nextInt()];
        System.out.println("시도할 회수는 몇 회 인가요?");
        int raceCount = scanner.nextInt();

        System.out.println("실행 결과");
        for (int i=0; i<raceCount; i++) {
            for (int j=0; j<carCount.length; j++) {
                Random random = new Random();
                if (random.nextInt(10) >= 4) {
                    carCount[j]++;
                }
                for (int k=0; k<carCount[i]; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
