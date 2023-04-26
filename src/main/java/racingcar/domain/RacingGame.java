package racingcar.domain;

public class RacingGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private Cars cars;
    private PlayCount playCount;

    public void start() {
        addCar();
        initPlayCount();
        playGame();
    }

    private void addCar() {
        cars = new Cars(inputView.participantApplication());
    }

    private void initPlayCount() {
        playCount = new PlayCount(inputView.playCount());
    }

    private void playGame() {
        resultView.start();
        for (int i = 0; i < playCount.getCount(); i++) {
            cars.moveAll();
            resultView.score(cars.list());
        }
        resultView.winner(Winner.getWinnerCarNames(cars));
    }
}
