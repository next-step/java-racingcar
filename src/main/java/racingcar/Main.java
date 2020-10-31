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
        View view = new View(game);

        while (game.checkNotGameOver()) {
            view.print();
            game.play();
        }
    }
}
