package Car;

import UI.InputView;
import UI.OutputView;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.getInt("자동차 대수는 몇 대 인가요?");
        int gameCount = inputView.getInt("시도할 회수는 몇 회 인가요?");

        RacingCar racingCar = new RacingCar(carCount, gameCount);
        racingCar.gameStart();

        OutputView outputView = new OutputView();
        outputView.printResult(racingCar);
    }
}
