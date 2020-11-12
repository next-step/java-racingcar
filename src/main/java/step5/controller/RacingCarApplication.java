package step5.controller;

import step5.domain.Car;
import step5.service.RacingCarGame;

import java.util.List;

import static step5.view.RacingCarUi.*;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();

        String[] carNames = receiveRacerInput();
        int numberOfMove = receiveMoveInput();

        close();

        List<Car> cars = racingCarGame.start(carNames);
        racingCarGame.carMove(numberOfMove, cars);

        finalWinner(cars);
    }
}
