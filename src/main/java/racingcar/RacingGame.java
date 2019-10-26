package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int runNumber = scanner.nextInt();

        List<String> result = new RacingGame().run(carNumber, runNumber);


    }

    private List<String> run(int carNumber, int runNumber) {

        return null;
    }
}
