package step3;

import step3.domain.CarRacingGame;
import step3.domain.gameStrategy.RandomCarGameStrategy;
import step3.view.OutputView;
import step3.view.dto.InputDto;
import step3.view.InputView;

public class Runner {

    public static void main(String[] args) {
        InputDto inputDto = InputView.load();
        CarRacingGame carRacingGame = CarRacingGame.of(inputDto, new RandomCarGameStrategy());
        carRacingGame.play();
        OutputView.printResult(carRacingGame);
    }

}