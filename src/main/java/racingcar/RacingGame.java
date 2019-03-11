package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    public void move(int[] carPositions, int index, int randomValue) {
        if(RacingGame.checkMove(randomValue)) {
            carPositions[index] = RacingGame.add(carPositions[index]);
        }
    }

    public static int add(int carPosition) {
        return carPosition + 1;
    }

    public static boolean checkMove(int value) {
        if(value >= 4) {
            return true;
        }
        return false;
    }

    public void resultView(int position) {
        for(int i=0; i<position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static int randomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        String value = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String count = scanner.nextLine();

        RacingGame racingGame = new RacingGame();
        int[] carPositions = new int[Integer.parseInt(value)];
        int time = Integer.parseInt(count);

        for(int i=0; i<time; i++) {
            for(int j=0; j<carPositions.length; j++) {
                int randomValue = RacingGame.randomValue();
                racingGame.move(carPositions, j, randomValue);
                racingGame.resultView(carPositions[j]);
            }
            System.out.println();
        }
    }
}
