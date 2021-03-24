package step4;

import step4.dto.InputDto;
import step4.view.InputView;
import step4.view.ResultView;

public class Main {
    public static void main(String[] args) {
        try {
            InputDto inputDto = InputView.input();
            RacingGame racingCar = new RacingGame(inputDto);
            racingCar.start();

            String winnerList = racingCar.findWinner();
            ResultView.printWinner(winnerList);
        } catch (IllegalArgumentException e) {
            System.out.println("어떤 에러 일까요? -> " + e);
        }
    }
}
