package Car;

import UI.InputView;
import UI.OutputView;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int carCount = carNames.length;
        int gameCount = inputView.getInt("시도할 회수는 몇 회 인가요?");

        RacingCar racingCar = new RacingCar(carCount, carNames);
        OutputView outputView = new OutputView();
        outputView.printResult(racingCar.getCars());
        for (int i = 0; i < gameCount; i++) {
            racingCar.gameStart();
            outputView.printResult(racingCar.getCars());
        }

        outputView.printWinner(racingCar.getWinner());

    }
}
