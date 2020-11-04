package racingcar;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();

        String carCsv = inputView.askCars();
        MoveStrategy strategy = new RandomMoveStrategy();
        CarGroup carGroup = new CarGroup(carCsv, strategy);

        int tryNum = inputView.askTryNum();
        RacingGame game = new RacingGame(carGroup, tryNum);

        RacingView racingView = RacingView.getInstance();
        racingView.printResultMsg();

        List<Memento> mementos = new LinkedList<>();
        while (game.checkNotGameOver()) {
            mementos.add(
                    carGroup.createMemento()
            );
            game.play();
        }

        for (Memento memento : mementos) {
            racingView.printCars(memento.getCars());
        }
        racingView.printWinners(carGroup.getWinners());
    }
}
