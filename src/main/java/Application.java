import domain.Car;
import domain.RacingCarGame;
import domain.RandomMoveStrategy;
import io.ConsoleScanner;
import io.ConsoleWriter;
import io.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView input = ConsoleScanner.input();
        List<Car> cars = new ArrayList<>();
        for (String owner : input.getOwners()) {
            cars.add(new Car(owner, new RandomMoveStrategy()));
        }

        RacingCarGame racingCarGame = new RacingCarGame(ConsoleScanner.input(), cars);
        ConsoleWriter.writeHeader();
        for (int i = 1; i <= racingCarGame.getInputView().getTryCount(); i++) {
            ConsoleWriter.writeGameInformation(racingCarGame.move());
        }
        ConsoleWriter.writeWinner(racingCarGame.findWinner());
    }
}
