package racingcar;

public class RacingCarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfTurns = inputView.getNumberOfTurns();
        Racing racing = Racing.withCondition(numberOfCars, numberOfTurns);
        while (!racing.hasRaceEnd()) {
            racing.race();
            //TODO: print car status
        }
    }
}
