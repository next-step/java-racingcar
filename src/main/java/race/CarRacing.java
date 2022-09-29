package race;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CarRacing {

    public static final int MOVE_CONDITION = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int countOfCar = getInputValue(sc);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int countOfTry = getInputValue(sc);

        String[] runningCar = new String[countOfCar];
        Arrays.fill(runningCar, "-");

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < countOfCar; i++) {
            System.out.println(runningCar[i]);
        }
        System.out.println();
        while (countOfTry > 1) {
            for (int i = 0; i < countOfCar; i++) {
                if (getRandomValue() >= 4) {
                    runningCar[i] += "-";
                }
                System.out.println(runningCar[i]);
            }

            System.out.println();
            --countOfTry;
        }
    }

    private static int getRandomValue() {
        return new Random().nextInt(MOVE_CONDITION);
    }

    private static int getInputValue(Scanner sc) {
        return sc.nextInt();
    }
}
