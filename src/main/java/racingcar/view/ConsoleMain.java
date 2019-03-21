package racingcar.view;

import racingcar.domain.RacingGame;

import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        RacingGame game = new RacingGame(carNames);
        GameResult result = game.play(time);
        ResultView.printTraces(result);
        ResultView.printWinner(result);
    }
}
