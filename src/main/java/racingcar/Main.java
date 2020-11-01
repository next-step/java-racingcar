package racingcar;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();
        int carNum = inputView.askCarNum();
        int tryNum = inputView.askTryNum();
        inputView.printResultMsg();

        MoveStrategy strategy = new RandomMoveStrategy();
        CarGroup cars = new CarGroup(carNum, strategy);
        RacingGame game = new RacingGame(cars, tryNum);
        RacingView racingView = new RacingView(game);

        while (game.checkNotGameOver()) {
            racingView.print();
            game.play();
        }
    }
}
