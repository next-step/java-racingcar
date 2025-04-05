package carrace.main;

import carrace.race.Race;
import carrace.view.InputView;
import carrace.view.OutputView;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 게임 준비
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = inputView.receiveCarNames(scanner.nextLine());

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numTry = inputView.receiveNumTry(scanner.nextInt());

        Race race = new Race(carNames);

        // 게임 진행 중의 상태 출력을 위해 outputView를 사용
        for (int i = 0; i < numTry; i++) {
            race.startSingleRound();
            outputView.printCurrentState(race.getVehicles());
        }
        outputView.printWinner(race.getWinner());

        scanner.close();
    }
}
