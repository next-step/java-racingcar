package racing;


import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.domain.Winners;
import racing.dto.GameVO;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameApplication {
    public static void main(String[] args) {

        InputView inputView = new InputView();

        GameVO gameVO = new GameVO(inputView.getNamesOfCars(), inputView.getNumberOfRounds());

        Cars cars = Cars.create(gameVO.getCarNames());

        RacingGame racingGame = new RacingGame(cars, gameVO.getRound());
        racingGame.play();

        Winners winners = racingGame.findWinner();
        ResultView.printWinner(winners);
    }
}
