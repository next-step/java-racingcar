package step5;

import step5.controller.RacingCarController;
import step5.domain.Car;
import step5.view.RacingCarUi;

import java.util.List;
import java.util.stream.IntStream;

import static step5.view.RacingCarUi.*;

public class RacingCarMain {

    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();

        String[] carNames = receiveRacerInput();
        int numberOfMove = receiveMoveInput();

        close();

        List<Car> cars = racingCarController.start(carNames);
        IntStream.range(0, numberOfMove)
                .mapToObj(i -> racingCarController.carMove())
                .forEach(RacingCarUi::resultPrint);

        finalWinner(cars);
    }
}
