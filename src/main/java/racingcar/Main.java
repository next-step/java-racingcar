package racingcar;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();

        String carCsv = inputView.askCars();
        MoveStrategy strategy = new RandomMoveStrategy();
        CarGroup carGroup = new CarGroup(carCsv, strategy);

        int tryNum = inputView.askTryNum();
        RacingGame game = new RacingGame(carGroup, tryNum);

        RacingView racingView = new RacingView(game);
        racingView.printResultMsg();
        while (game.checkNotGameOver()) {
            racingView.print();
            game.play();
        }

        racingView.printWinners();
    }
}
