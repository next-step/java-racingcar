package racingcar;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();
        String carCsv = inputView.askCars();
        int tryNum = inputView.askTryNum();
        inputView.printResultMsg();

        MoveStrategy strategy = new RandomMoveStrategy();
        CarGroup carGroup = new CarGroup(carCsv, strategy);
        RacingGame game = new RacingGame(carGroup, tryNum);
        RacingView racingView = new RacingView(game);

        while (game.checkNotGameOver()) {
            racingView.print();
            game.play();
        }

        racingView.printWinners();
    }
}
