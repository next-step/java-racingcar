package racingcar;

import racingcar.car.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarApplication {
    private static final String DELIMITER = ",";
    private static final int ONE = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요 ?");
        int numberOfTime = scanner.nextInt();

        System.out.println("실행 결과");

        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(names.split(DELIMITER), new RandomMovingStrategy());
        RacingScore racingScore = null;
        List<RacingScore> racingScores = new ArrayList<>();

        for(int i = 0; i < numberOfTime; i++) {
            racingScore = racingGame.execute();
            racingScores.add(racingScore);
        }

        resultView.print(racingScores);
        resultView.printWinner(racingScore.getWinner());
    }
}
