package Step3;

import java.util.List;

public class Main {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        String carNameInput = inputView.readStringInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = carNameInput.split(",");

        int playNum = inputView.readIntegerInput("시도할 횟수는 몇 회 인가요?");

        RacingGame racingGame = new RacingGame(carNames.length, playNum);
        List<List<Integer>> gameRecord = racingGame.play();
        List<Integer> winnersIdx = racingGame.getWinner();

        inputView.printResult(gameRecord, carNames);
        inputView.printWinner(carNames, winnersIdx);
    }
}
