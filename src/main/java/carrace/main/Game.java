package carrace.main;

import carrace.race.Race;
import carrace.view.InputView;
import carrace.view.OutputView;

public class Game {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 게임 준비
        String[] carNames = inputView.receiveCarNames();
        int numTry = inputView.receiveNumTry();

        Race race = new Race(carNames);

        // 의존성을 변경하기위해 start 대신 startSingleRound를 사용
        for (int i = 0; i < numTry; i++) {
            race.startSingleRound();
            outputView.printCurrentState(race.getVehicles());
        }
        outputView.printWinner(race.getWinner());
    }
}
