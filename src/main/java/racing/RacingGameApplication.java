package racing;


import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.dto.GameVO;
import racing.utils.ValidationUtil;
import racing.view.InputView;

public class RacingGameApplication {
    public static void main(String[] args) {

        InputView inputView = new InputView();

        GameVO gameVO = new GameVO(inputView.getNumberOfCars(), inputView.getNumberOfRounds());

        ValidationUtil.validateInput(gameVO);

        Cars cars = Cars.create(gameVO.getCarNo());

        RacingGame racingGame = new RacingGame(cars, gameVO.getRoundNo());
        racingGame.play();

    }
}
