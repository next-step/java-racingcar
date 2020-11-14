package step5.controller;

import step5.domain.Car;
import step5.domain.RacingCarGame;
import step5.view.RacingCarUi;

import java.util.List;
import java.util.stream.IntStream;

import static step5.view.RacingCarUi.*;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();

        String[] carNames = receiveRacerInput();
        int numberOfMove = receiveMoveInput();

        close();

        List<Car> cars = racingCarGame.start(carNames);
        IntStream.range(0, numberOfMove)
                .mapToObj(i -> racingCarGame.carMove(cars))
                .forEach(RacingCarUi::resultPrint);

        finalWinner(cars);
    }


}
