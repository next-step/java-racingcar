package step5;

import step5.controller.RacingCarController;
import step5.domain.Car;

import java.util.List;

import static step5.view.RacingCarUi.*;

public class RacingCarMain {

    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();

        String[] carNames = receiveRacerInput();
        int numberOfMove = receiveMoveInput();

        close();

        List<Car> cars = racingCarController.start(carNames);
        racingCarController.carMove(numberOfMove);

        finalWinner(cars);
    }
}
