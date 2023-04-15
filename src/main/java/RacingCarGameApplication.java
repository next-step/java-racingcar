import domain.Car;
import domain.RacingCarGame;
import domain.RandomMoveStrategy;
import io.ConsoleScanner;
import io.ConsoleWriter;
import io.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView inputView = ConsoleScanner.input();
        List<Car> cars = new ArrayList<>();
        for (String owner : inputView.getOwners()) {
            cars.add(new Car(owner, new RandomMoveStrategy()));
        }

        RacingCarGame racingCarGame = new RacingCarGame(cars);

        ConsoleWriter.writeHeader();
        for (int i = 1; i <= inputView.getTryCount(); i++) {
            racingCarGame.move();
            ConsoleWriter.writeGameInformation(cars);
        }
        ConsoleWriter.writeWinner(racingCarGame.findWinner());
    }
}
