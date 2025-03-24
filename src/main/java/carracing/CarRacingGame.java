package carracing;

public class CarRacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfRounds = inputView.getNumberOfRounds();

        MovingStrategy movingStrategy = new RandomMovingStrategy();
        Race race = new Race(numberOfCars, numberOfRounds, movingStrategy);
        ResultView resultView = new ResultView();
        System.out.println("실행 결과");
        race.playGame(resultView);
    }
}
