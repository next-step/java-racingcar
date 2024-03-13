package racing;


import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.dto.GameVO;
import racing.view.InputView;

import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);

        GameVO gameVO = GameVO.validateInput(inputView.getNumberOfCars(), inputView.getNumberOfRounds());

        Cars cars = Cars.create(gameVO.getCarNo());

        RacingGame racingGame = new RacingGame(cars, gameVO.getRoundNo());
        racingGame.play();

        scanner.close();
    }
}
