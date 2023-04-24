package study.step3;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        CarRacing carRacing = new CarRacing();

        carRacing.initRacing(inputView.readCarName());
        int round = inputView.readGameRound();
        List<Car> cars = null;

        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            cars = carRacing.moveCars();
            resultView.printStateBoard(cars);
        }

        resultView.printWinner(carRacing.getCars());
    }
}
