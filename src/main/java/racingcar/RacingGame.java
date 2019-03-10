package racingcar;

import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class RacingGame {

    private static final int BOUND = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요? ");
        int numberOfCars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요? ");
        int numberOfTimes = scanner.nextInt();

        int[][] positionsOfCars = makeMoveOfCars(numberOfCars, numberOfTimes);

        System.out.println("실행 결과");
        showGame(positionsOfCars);
    }

    private static void showGame(int[][] positionsOfCars) {

        for (int[] positionsOfCar : positionsOfCars) {

            for (int position : positionsOfCar) {
                String move = StringUtils.repeat("-", position);
                System.out.println(move);
            }

            System.out.print("\n");
        }

    }

    public static int[][] makeMoveOfCars(int numberOfCars, int numberOfTimes) {
        int[][] positionsOfCars = new int[numberOfTimes][numberOfCars];

        for (int times = 0; times < numberOfTimes; times++) {
            for (int i = 0; i < numberOfCars; i++) {
                int randomNum = generateRandomNum();
                int prevPosition = positionsOfCars[times - 1 < 0 ? 0 : times - 1][i];

                if (checkCanMove(randomNum)) {
                    positionsOfCars[times][i] = prevPosition + 1;
                }

                if (!checkCanMove(randomNum)) {
                    positionsOfCars[times][i] = prevPosition;
                }
            }
        }

        return positionsOfCars;
    }

    public static int generateRandomNum() {
        Random random = new Random();

        return random.nextInt(BOUND);
    }

    public static boolean checkCanMove(int num) {
        return num >= 4 && num <= 9;
    }
}
