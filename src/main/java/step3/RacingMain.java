package step3;

import step3.domain.Car;
import step3.domain.Racing;
import step3.util.InputView;
import step3.util.ResultView;
import step3.util.Validator;

import java.util.List;
import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {

        InputView inputView = new InputView(new Scanner(System.in));
        int carCount = inputView.enterCarCount();
        int gameCount = inputView.enterGameCount();

        Validator validator = new Validator();
        validator.checkInput(carCount, gameCount);

        ResultView resultView = new ResultView();

        Racing racing = new Racing();
        List<Car> cars = racing.initCars(carCount);

        resultView.printGameResultHeader();
        for(int i = 0; i < gameCount; i++) {
            racing.startRace(cars);
            resultView.printGameResult(cars);
            resultView.printNewLine();
        }
    }
}
