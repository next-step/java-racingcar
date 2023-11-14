package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.StringParser;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameRunner {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        InputView inputView = new InputView();
        String input = inputView.enter();
        String[] names = StringParser.split(input);
        System.out.println("시도할 회수는 몇회인가요?");
        int numbers = inputView.enterNumber();

        Cars cars = new Cars(names);
        ResultView resultView = new ResultView();
        resultView.printCars(cars);
        System.out.println("실행 결과:");
        for (int i = 0; i < numbers; i++) {
            cars.moveCars();
            resultView.printCars(cars);
        }
        resultView.printWinners(cars);
    }
}
