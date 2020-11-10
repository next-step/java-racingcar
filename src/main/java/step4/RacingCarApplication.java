package step4;

import java.util.List;
import java.util.stream.IntStream;

import static step4.RacingCarUi.*;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();

        String carNames = receiveRacerInput();
        int numberOfMove = receiveMoveInput();

        List<Car> cars = racingCarGame.start(carNames);
        IntStream.range(0, numberOfMove).forEach(i -> {
            racingCarGame.carMove(cars);
            resultPrint(cars);
        });
        finalWinner(cars);

        close();
    }
}
