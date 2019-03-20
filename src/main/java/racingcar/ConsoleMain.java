package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String cars = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String count = scanner.nextLine();

        int time = Integer.parseInt(count);
        RacingGame racingGame = new RacingGame(cars, Integer.parseInt(count));
        ResultView resultView = new ResultView();
        List<Car> gameResult = null;

        for (int i = 0; i < time; i++) {
            gameResult = racingGame.racing();
            resultView.showRaceResult(gameResult);
        }

        resultView.showWinner(gameResult);
    }
}
