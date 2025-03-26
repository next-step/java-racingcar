package carracing;

public class CarRacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int numberOfRounds = inputView.getNumberOfRounds();

        MovingStrategy movingStrategy = new RandomMovingStrategy();
        Race race = new Race(carNames, numberOfRounds, movingStrategy);
        ResultView resultView = new ResultView();
        System.out.println("실행 결과");
        race.playGame(resultView);
        race.getWinners(resultView);
    }
}
