package racingcar;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();
        int carNum = inputView.askCarNum();
        int tryNum = inputView.askTryNum();
        inputView.printResultMsg();

        MoveStrategy strategy = new RandomMoveStrategy();
        CarCollection collection = new CarCollection(carNum, strategy);
        RacingGame game = new RacingGame(collection, tryNum);
        RacingView racingView = new RacingView(game);

        while (game.checkNotGameOver()) {
            racingView.print();
            game.play();
        }
    }
}
