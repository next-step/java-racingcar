package controller;

import domain.CarRacing;
import domain.NumberGenerator;
import view.InputView;
import view.ResultView;

import java.util.Random;

public class CarRacingController {

    private final InputView inputView;
    private final ResultView resultView;
    private final Random random;

    public CarRacingController(InputView inputView, ResultView resultView, Random random) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.random = random;
    }


    public void startCarRacing() {
        CarRacing carRacing = new CarRacing(new NumberGenerator(random));
        String names = inputView.getInputStringValue("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        carRacing.makingCar(names);
        int executeCount = inputView.getInputIntValue("시도할 회수는 몇 회 인가요?");
        resultView.showResultComment("실행 결과");
        while (executeCount-- > 0) {
            carRacing.executeRace();
            resultView.showCarRacing(carRacing.cars());
        }
        resultView.showResultCarRacing(carRacing.getWinningRaceCars());
    }
}
