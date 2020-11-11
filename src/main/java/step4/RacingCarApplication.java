package step4;

import java.util.List;

import static step4.RacingCarUi.*;

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
