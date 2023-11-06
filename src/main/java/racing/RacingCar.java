package racing;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    static String DISTANCE = "-";

    public static void main(String[] args) {
        print("자동차 대수는 몇 대 인가요?");
        int[] carDistance = new int[input()];
        print("시도할 회수는 몇 회 인가요?");
        int raceCount = input();

        print("실행 결과");
        for (int i=0; i<raceCount; i++) {
            carDistance = race(carDistance);
            print("");
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static int input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static boolean move() {
        Random random = new Random();
        return random.nextInt(10) >= 4;
    }

    private static int[] race(int[] carDistance) {
        for (int i=0; i<carDistance.length; i++) {
            if (move()) {
                carDistance[i]++;
            }
            print(DISTANCE.repeat(carDistance[i]));
        }
        return carDistance;
    }
}
