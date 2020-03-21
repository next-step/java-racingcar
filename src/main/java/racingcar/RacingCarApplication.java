package racingcar;

import racingcar.car.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarApplication {
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요 ?");
        String names = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요 ?");
        int numberOfTime = scanner.nextInt();

        System.out.println("실행 결과");

        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(names.split(DELIMITER), new RandomMovingStrategy());
        List<RacingScore> results = new ArrayList<>();

        for(int i = 0; i < numberOfTime; i++) {
            results.add(racingGame.execute());
        }

        resultView.print(results);
    }
}
