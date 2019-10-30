package racing;

import java.util.Scanner;
import racing.domain.RacingGame;
import racing.view.RacingScoreView;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tries = scanner.nextInt();

        InputChecker inputChecker = new InputChecker(input, tries);

        RacingGame racingGame = new RacingGame(inputChecker.getNames(), inputChecker.getTries());
        racingGame.doRaces();

        RacingScoreView view = new RacingScoreView(racingGame);
        view.printResults();
        view.printWinner();

    }

}
