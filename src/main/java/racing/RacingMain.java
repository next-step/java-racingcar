package racing;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static racing.ResultView.printResult;

public class RacingMain {

    public static final int GO_CONDITION = 4;
    public static final int RANDOM_MAX = 10;

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = scanner.nextInt();

        System.out.println();
        System.out.println("실행 결과");

        String[] carPosition = new String[carCount];
        Arrays.fill(carPosition, "-");

        printResult(carCount, tryCount, carPosition);
    }


}
