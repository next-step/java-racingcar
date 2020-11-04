package racingcar;

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
        while (game.checkNotGameOver()) {
            game.printCars(racingView.carsConsumer);
            game.play();
        }

        game.printWinners(racingView.winnersConsumer);
    }
}
