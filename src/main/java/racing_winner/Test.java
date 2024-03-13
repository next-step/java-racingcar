package racing_winner;

import racing.RandomFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        InputLayer inputLayer = new InputLayer(new InputConsole());
        CarRacing carRacing = new CarRacing(inputLayer.getCarNames(), inputLayer.getGameCount(), new RandomFactory(), new CarRacingPrinter());
        carRacing.game();
    }
}
